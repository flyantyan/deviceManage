package com.nuc.device.test.dao;

import com.alibaba.fastjson.JSON;
import com.nuc.device.bean.User;
import com.nuc.device.dao.UserDao;
import com.nuc.device.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/27
 * Time:2:26
 */
public class UserDaoTest extends SpringTest {
    @Autowired
    private UserDao userDao;
    @Test
    public void testInsertDao(){
        User user=new User();
        user.setUserName("zhangsan");
        user.setUserPwd("123456");
        user.setUserTel("18235140527");
        user.setRealName("leopold");
        user.setUserSex(1);
        user.setUserRole(1);
        user.setUserPower("1,2,3");
        user.setCreateEmpId(123456);
        user.setModifyEmpId(123456);
        userDao.insertUser(user);

        User user1=new User();
        user1.setUserName("zhangsan");
        System.out.println(JSON.toJSONString(userDao.queryUserList(user1)));
    }
}
