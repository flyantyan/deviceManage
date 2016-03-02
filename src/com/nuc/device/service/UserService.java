package com.nuc.device.service;

import com.nuc.device.bean.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:0:08
 */
@Service
public interface UserService {
    public List<User> queryUserList(User user);
    public void saveUser(User user);
    public User queryUserById(long id);
    public void delUser(User user);
    public void resetPwd(User user);
    public void updateUser(User user);
    public void allotMenu(Long userId,String menuId);
}
