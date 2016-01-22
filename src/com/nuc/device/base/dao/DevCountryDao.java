package com.nuc.device.base.dao;

import com.nuc.device.base.bean.Country;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:23:45
 */
public interface DevCountryDao {
    public List<Country> queryCountryList();
    public Country queryCountryById(Long id);
    public void updateCountry(Country country);
    public void delCountry(Country country);
    public void insertCountry(Country country);
}
