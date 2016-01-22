package com.nuc.device.intercepter;

import com.nuc.device.util.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * Mybatis -mysql分页拦截器
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:16:18
 */
@Intercepts({@Signature(type= StatementHandler.class,method = "prepare",args = {Connection.class}),
        @Signature(type = ResultSetHandler.class,method = "handleResultSets",args = {Statement.class})})
public class PageInterceptor implements Interceptor {
    private static final Logger logger=Logger.getLogger(PageInterceptor.class);

    public static final ThreadLocal<Page> localPage=new ThreadLocal<Page>();

    /**
     * 开始分页
     * @param pageNum
     * @param pageSize
     */
    public static void startPage(int pageNum,int pageSize){
        localPage.set(new Page(pageNum,pageSize));
    }

    /**
     * 结束分页并返回结果，该方法必须被调用，否则localPage会一直保存下去，直到下一次startPage
     * @return
     */
    public static Page endPage(){
        Page page=localPage.get();
        localPage.remove();
        if(page.getPageNum()==1){
            page.setHasPre(false);
        }
        if(page.getPages()==page.getPageNum()){
            page.setHasNext(false);
        }
        return page;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if(localPage.get()==null){
            return invocation.proceed();
        }
        if(invocation.getTarget() instanceof StatementHandler){
            StatementHandler statementHandler= (StatementHandler) invocation.getTarget();
            MetaObject metaStateMentHandler= SystemMetaObject.forObject(statementHandler);
            //分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面两次循环可以分离出最原始的目标类）
            while(metaStateMentHandler.hasGetter("h")){
                Object object=metaStateMentHandler.getValue("h");
                metaStateMentHandler=SystemMetaObject.forObject(object);
            }
            //分离最后一个代理对象目标类
            while(metaStateMentHandler.hasGetter("target")){
                Object object=metaStateMentHandler.getValue("target");
                metaStateMentHandler=SystemMetaObject.forObject(object);
            }
            MappedStatement mappedStatement= (MappedStatement) metaStateMentHandler.
                    getValue("delegate.mappedStatement");
            //分页信息
            Page page=localPage.get();
            BoundSql boundSql= (BoundSql) metaStateMentHandler.getValue("delegate.boundSql");
            String sql=boundSql.getSql();
            //重写分页Sql
            String pageSql=buildPageSql(sql,page);
            metaStateMentHandler.setValue("delegate.boundSql.sql",pageSql);
            Connection connection= (Connection) invocation.getArgs()[0];
            //重设分页参数的总页数等
            setPageParameter(sql,connection,mappedStatement,boundSql,page);
            //将执行权交给下一个拦截机器
            return invocation.proceed();
        }else if(invocation.getTarget() instanceof ResultSetHandler){
            Object result=invocation.proceed();
            Page page=localPage.get();
            page.setResult((List)result);
            return  result;
        }
        return null;
    }

    /**
     * 只拦截这两种类型 StatementHandler&ResultSetHandler
     * @param target
     * @return
     */
    @Override
    public Object plugin(Object target) {
        if(target instanceof StatementHandler || target instanceof  ResultSetHandler){
            return Plugin.wrap(target, this);
        }else{
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 修改原SQl为分页SQL
     * @param sql
     * @param page
     * @return
     */
    private String buildPageSql(String sql,Page page){
        StringBuilder pageSql=new StringBuilder(sql);
        pageSql.append(" limit ").append((page.getPageNum()-1)*page.getPageSize());
        pageSql.append(",").append(page.getPageSize());
        return pageSql.toString();
    }

    /**
     * 获取总记录数
     * @param sql
     * @param connection
     * @param mappedStatement
     * @param boundSql
     * @param page
     */
    private void setPageParameter(String sql,Connection connection,MappedStatement mappedStatement,
                                  BoundSql boundSql,Page page) throws SQLException {
        String countSql="select count(0) from ("+sql+") temp";
        PreparedStatement countStmt=null;
        ResultSet rs=null;
        try {
            countStmt=connection.prepareStatement(countSql);
            BoundSql countBS=new BoundSql(mappedStatement.getConfiguration(),countSql,
                    boundSql.getParameterMappings(),boundSql.getParameterObject());
            setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
            rs=countStmt.executeQuery();
            int totalCount=0;
            if(rs.next()){
                totalCount=rs.getInt(1);
            }
            page.setTotal((long)totalCount);
            int totalPage=totalCount/page.getPageSize()+((totalCount%page.
                    getPageSize()==0)?0:1);
            page.setPages(totalPage);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                countStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 带入参数值
     * @param ps
     * @param mappedStatement
     * @param boundSql
     * @param paramterObject
     * @throws SQLException
     */
    private void setParameters(PreparedStatement ps,MappedStatement mappedStatement,BoundSql boundSql,
                               Object paramterObject) throws SQLException{
        ParameterHandler parameterHandler=new DefaultParameterHandler(mappedStatement,paramterObject,boundSql);
        parameterHandler.setParameters(ps);
    }
}
