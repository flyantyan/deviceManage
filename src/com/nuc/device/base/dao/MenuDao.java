package com.nuc.device.base.dao;


import com.nuc.device.base.bean.Menu;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:48
 */
public interface MenuDao {
    public List<Menu> queryMenuListByIds(String ids);
    public List<Menu> queryMenuList();
}
