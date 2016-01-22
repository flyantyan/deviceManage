package com.nuc.device.base.bean;

import com.nuc.device.base.BaseBean;

/**
 * 国家信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:05
 */
public class Country extends BaseBean {
    private String countryNo;//国家编号
    private String countryName;//国家名称

    public String getCountryNo() {
        return countryNo;
    }

    public void setCountryNo(String countryNo) {
        this.countryNo = countryNo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
