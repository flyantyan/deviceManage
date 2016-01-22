package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备来源信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:25
 */
public class Origin extends BaseBean{
    private String originNo;//来源编号
    private String originName;//来源名称

    public String getOriginNo() {
        return originNo;
    }

    public void setOriginNo(String originNo) {
        this.originNo = originNo;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }
}
