package com.nuc.device.listener;


import com.alibaba.fastjson.JSON;
import com.nuc.device.base.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Map;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:45
 */
public class InitSystemListener implements ServletContextListener{
    private final static Logger logger= LoggerFactory.getLogger(InitSystemListener.class);
    protected static ServletContext application;
    private WebApplicationContext webApplication;
    protected final static String CATEGORYLIST="categoryList";
    protected final static String COUNTRYLIST="countryList";
    protected final static String DEPOSITLIST="depositList";
    protected final static String ORIGINLIST="originList";
    protected final static String DIRECTIONLIST="directionList";
    protected final static String FOUNDSBULIST="foundSubList";
    public InitSystemListener() {
        super();
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        webApplication= WebApplicationContextUtils.
                getWebApplicationContext(event.getServletContext());
        application= webApplication.getServletContext();
        this.initParam();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
    private void initParam(){
        application.setAttribute(CATEGORYLIST, webApplication.getBean(CategoryDao.class).queryCategoryList());
        application.setAttribute(COUNTRYLIST, webApplication.getBean(DevCountryDao.class).queryCountryList());
        application.setAttribute(DEPOSITLIST, webApplication.getBean(DevDepositDao.class).queryDepositList());
        application.setAttribute(ORIGINLIST, webApplication.getBean(DevOriginDao.class).queryOriginList());
        application.setAttribute(DIRECTIONLIST, webApplication.getBean(DirectionDao.class).queryDirectionList());
        application.setAttribute(FOUNDSBULIST,webApplication.getBean(FoundSubDao.class).queryFoundSubList());
    }
}
