package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备使用方向信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:27
 */
public class Direction extends BaseBean{
    private String direcNo;//使用方向编号
    private String direcName;//使用方向名称

    public String getDirecNo() {
        return direcNo;
    }

    public void setDirecNo(String direcNo) {
        this.direcNo = direcNo;
    }

    public String getDirecName() {
        return direcName;
    }

    public void setDirecName(String direcName) {
        this.direcName = direcName;
    }
}
