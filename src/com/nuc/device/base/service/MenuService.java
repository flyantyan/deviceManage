package com.nuc.device.base.service;

import com.nuc.device.base.bean.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:1:59
 */
public interface MenuService {
    public List<Menu> getMenu(String menuIds);
    public Map<Menu,List<Menu>> getAllMenu();
}
