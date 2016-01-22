package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 系统菜单信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:49
 */
public class Menu extends BaseBean {
    private int menuId;
    private String menuName;//菜单名称
    private String menuUrl;//菜单url
    private int parentId;//上级菜单id

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }
}
