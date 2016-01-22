package com.nuc.device.base.service.impl;

import com.nuc.device.base.bean.Menu;
import com.nuc.device.base.dao.MenuDao;
import com.nuc.device.base.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:2:03
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getMenu(String menuIds) {
        List<Menu> list1=menuDao.queryMenuListByIds(menuIds);
        return list1;
    }

    @Override
    public Map<Menu, List<Menu>> getAllMenu() {
        List<Menu> list1=menuDao.queryMenuList();
        return warpMenuMap(list1);
    }
    private Map<Menu, List<Menu>> warpMenuMap(List<Menu> list1){
        Map<Menu, List<Menu>> map=new HashMap<Menu, List<Menu>>();
        for (Menu menu:list1){
            if(menu.getParentId()==0){
                List<Menu> list=new ArrayList<Menu>();
                int parentId=menu.getMenuId();
                for(Menu menu1:list1){
                    if(menu1.getParentId()==parentId){
                        list.add(menu1);
                    }
                }
                map.put(menu,list);
            }
        }
        if(map==null){
            for(Menu menu:list1){
                map.put(menu,null);
            }
        }
        return map;
    }
}
