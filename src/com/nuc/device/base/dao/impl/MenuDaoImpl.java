package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Menu;
import com.nuc.device.base.dao.MenuDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:53
 */
@Repository
public class MenuDaoImpl extends BaseDao implements MenuDao {
    @Override
    public List<Menu> queryMenuListByIds(String ids) {
        return getSession().selectList("menu.queryMenuListByIds",ids);
    }

    @Override
    public List<Menu> queryMenuList() {
        return getSession().selectList("menu.queryMenuList");
    }
}
