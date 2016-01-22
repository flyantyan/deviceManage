package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 系统权限信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:39
 */
public class Power extends BaseBean {
    private String powerName;//权限名称
    private String powerContext;//权限内容

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getPowerContext() {
        return powerContext;
    }

    public void setPowerContext(String powerContext) {
        this.powerContext = powerContext;
    }
}
