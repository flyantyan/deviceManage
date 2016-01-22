package com.nuc.device.test.service;

import com.alibaba.fastjson.JSON;
import com.nuc.device.bean.User;
import com.nuc.device.service.UserService;
import com.nuc.device.test.SpringTest;
import com.nuc.device.util.PagerHelper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:16:48
 */
public class UserServiceTest extends SpringTest {
    @Autowired
    private UserService userService;
    @Test
    public void TestQueryUserList(){
        User user = new User();
        List<User> list=userService.queryUserList(user);
        System.out.println(JSON.toJSONString(list));
    }
}
