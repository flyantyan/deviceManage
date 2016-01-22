package com.nuc.device.bean;

import com.nuc.device.base.BaseBean;
import com.nuc.device.base.poi.annotation.ExcelColumnName;

/**
 * 用户信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:43
 */
public class User extends BaseBean {
    @ExcelColumnName("用户名")
    private String userName;//用户名
    private String userPwd;//密码
    @ExcelColumnName("真实姓名")
    private String realName;//真实姓名
    private int userSex;//性别
    private Integer userRole;//用户角色
    @ExcelColumnName("电话")
    private String userTel;//电话
    private String userPower;//用户权限
    private String userMenu;//用户菜单列表
    private String remark;//备注
    @ExcelColumnName("性别")
    private String sexDesc;//性别描述
    @ExcelColumnName("角色")
    private String roleDesc;//角色描述

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        if(realName.equals("")){
            this.realName=null;
        }else
        this.realName = realName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        if(userSex==1){
            this.setSexDesc("男");
        }else this.setSexDesc("女");
        this.userSex = userSex;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        switch (userRole){
            case 1:this.setRoleDesc("学生");
                break;
            case 2:this.setRoleDesc("教师1");
                break;
            case 3:this.setRoleDesc("教师2");
                break;
            case 4:this.setRoleDesc("管理员");
                break;
            default:break;
        }
        this.userRole = userRole;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPower() {
        return userPower;
    }

    public void setUserPower(String userPower) {
        this.userPower = userPower;
    }

    public String getUserMenu() {
        return userMenu;
    }

    public void setUserMenu(String userMenu) {
        this.userMenu = userMenu;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSexDesc() {
        return sexDesc;
    }

    public void setSexDesc(String sexDesc) {
        this.sexDesc = sexDesc;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
