package com.nuc.device.base.controller;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:25
 */
public interface JspageConstant {
    public final static String INDEX="index";
    public final static String LOGIN="login";
    public final static String USERLIST="userList";
    public final static String USEREDIT="userEdit";
    public final static String MENULIST="system/menuList";
    public final static String DEVORIGIN="system/devOrigin";
    public final static String DEVCATEGORY="system/devCategory";
    public final static String DEVCOUNTRY="system/devCountry";
    public final static String DEVDEPOSIT="system/devDeposit";
    public final static String DEVDIRECTION="system/devDirection";
    public final static String DEVFOUNDSUB="system/devFoundSub";
    public final static String DEVINFOLIST="dev/devInfoList";
    public final static String APPLYLIST="dev/applyList";
    public final static String MAINTAINLIST="dev/maintainList";
    public final static String DUMPLIST="dev/dumpList";
    public final static String USERDETAIL="userDetail";
    public final static String UPDATEPWD="updatePwd";
    public final static String ADDSYSTEMPARAM="system/addSystemParam";
}
