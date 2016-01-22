package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.User;
import com.nuc.device.dao.UserDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:11
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> queryUserList(User user) {
        return getSession().selectList("user.queryUserList", user);
    }

    @Override
    public User queryUserById(long id) {
        return getSession().selectOne("user.queryUserById",id);
    }

    @Override
    public void insertUser(User user) {
        getSession().insert("user.insertUser",user);
    }

    @Override
    public void updateUser(User user) {
        getSession().update("user.updateUser",user);
    }

    @Override
    public void delUser(User user) {
        getSession().update("user.delUser",user);
    }
}
