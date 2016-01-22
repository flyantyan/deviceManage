package com.nuc.device.base;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:0:22
 */
public class BaseDao {
    private final static Logger logger=Logger.getLogger(BaseDao.class);
    @Autowired
    private SqlSessionFactory factory;
    private SqlSession session;
    public SqlSession getSession(){
        session=factory.openSession();
        return session;
    }
    public void closeSession(){
        if(session!=null){
            session.close();
        }else{
            logger.error("session is null!");
        }
    }
}
