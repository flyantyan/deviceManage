package com.nuc.device.base;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/30
 * Time:0:02
 */
public class CommonConstant {
    /*用户角色常量*/
    //学生
    public final static int ROLE_STUDENT=1;
    //教师无管理员权限
    public final static int ROLE_TEACHER1=2;
    //教师具备管理员权限
    public final static int ROLE_TEACHER2=3;
    //系统管理员
    public final static int ROLE_ADMIN=4;

    /*默认菜单常量*/
    //学生
    public final static String ROLE_STUDENT__MENU="1";
    //教师无管理员权限
    public final static String ROLE_TEACHER1__MENU="1,2";
    //教师具备管理员权限
    public final static String ROLE_TEACHER2__MENU="1,2,3";
    //系统管理员
    public final static String ROLE_ADMIN__MENU="1,2,3,4";
}
