package com.nuc.device.base.poi;

import com.nuc.device.bean.User;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/21
 * Time:23:02
 */
public class Test {
    public static void main(String[] args) {
        User user=new User();
        user.setId(Long.valueOf("1010101"));
        user.setUserName("张三");
        user.setUserPwd("123456");
        user.setRealName("张三");
        user.setUserTel("18235140527");
        user.setSexDesc("男");
        user.setRoleDesc("超级管理员");
        user.setCreateTime(new Date());
        List list=new ArrayList();
        list.add(user);
        ExportExcel exportExcel=new ExportExcel(list,User.class,String.valueOf(System.currentTimeMillis()),"d:/");
        exportExcel.export();
    }
}
