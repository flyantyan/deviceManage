package com.nuc.device.dao;

import com.nuc.device.bean.User;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/27
 * Time:2:07
 */
public interface UserDao {
    public List<User> queryUserList(User user);
    public User queryUserById(long id);
    public void insertUser(User user);
    public void updateUser(User user);
    public void delUser(User user);
}
