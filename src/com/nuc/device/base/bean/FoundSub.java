package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备经费科目信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:19
 */
public class FoundSub extends BaseBean {
    private String foundNo;//经费编号
    private String foundName;//经费名称
    public String getFoundNo() {
        return foundNo;
    }

    public void setFoundNo(String foundNo) {
        this.foundNo = foundNo;
    }

    public String getFoundName() {
        return foundName;
    }

    public void setFoundName(String foundName) {
        this.foundName = foundName;
    }
}
