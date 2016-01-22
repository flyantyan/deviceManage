package com.nuc.device.service.impl;

import com.nuc.device.base.CommonConstant;
import com.nuc.device.bean.User;
import com.nuc.device.dao.UserDao;
import com.nuc.device.service.UserService;
import com.nuc.device.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:0:10
 */
@Service
public class UserServiecImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryUserList(User user) {
        return userDao.queryUserList(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        switch (user.getUserRole()){
            case CommonConstant.ROLE_STUDENT:
                user.setUserMenu(CommonConstant.ROLE_STUDENT__MENU);
                break;
            case CommonConstant.ROLE_TEACHER1:
                user.setUserMenu(CommonConstant.ROLE_TEACHER1__MENU);
                break;
            case CommonConstant.ROLE_TEACHER2:
                user.setUserMenu(CommonConstant.ROLE_TEACHER2__MENU);
                break;
            case CommonConstant.ROLE_ADMIN:
                user.setUserMenu(CommonConstant.ROLE_ADMIN__MENU);
                break;
            default:break;
        }
        user.setUserPwd(CommonUtil.toMD5String("123456"));
        userDao.insertUser(user);
    }
    @Override
    public User queryUserById(long id){
        return userDao.queryUserById(id);
    }

    @Override
    public void delUser(User user) {
        userDao.delUser(user);
    }

    @Override
    public void resetPwd(User user) {
        user.setUserPwd(CommonUtil.toMD5String("123456"));
        userDao.updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
