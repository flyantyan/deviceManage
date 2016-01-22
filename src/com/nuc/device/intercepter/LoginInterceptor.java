package com.nuc.device.intercepter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:4:51
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    private final static Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);
    private final static String LOGINPAGE="/WEB-INF/jsp/login.jsp";
    private final static String LOGINACTION="/deviceManager/user/login.do";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        if(LOGINACTION.equals(request.getRequestURI())){
            return true;
        }
        if(request.getSession().getAttribute("user")==null){
            request.getRequestDispatcher(LOGINPAGE).forward(request,response);
            return false;
        }else
            return true;
    }
}
