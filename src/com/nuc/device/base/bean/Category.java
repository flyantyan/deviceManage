package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备类型
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:00
 */
public class Category extends BaseBean {
    private String cateNo;//类别编号
    private String cateName;//类别名称

    public String getCateNo() {
        return cateNo;
    }

    public void setCateNo(String cateNo) {
        this.cateNo = cateNo;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }
}
