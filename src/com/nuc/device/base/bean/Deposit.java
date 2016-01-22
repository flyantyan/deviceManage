package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备存放地信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:17
 */
public class Deposit extends BaseBean{
    private String depositNo;//存放地编号
    private String depositName;//存放地名称

    public String getDepositNo() {
        return depositNo;
    }

    public void setDepositNo(String depositNo) {
        this.depositNo = depositNo;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }
}
