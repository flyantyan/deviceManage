package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Country;
import com.nuc.device.base.dao.DevCountryDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:23:46
 */
@Repository
public class DevCountryDaoImpl extends BaseDao implements DevCountryDao{
    @Override
    public List<Country> queryCountryList() {
        return getSession().selectList("country.queryCountryList");
    }

    @Override
    public Country queryCountryById(Long id) {
        return getSession().selectOne("country.queryCountryById",id);
    }

    @Override
    public void updateCountry(Country country) {
        getSession().update("country.updateCountry",country);
    }

    @Override
    public void delCountry(Country country) {
        getSession().update("country.delCountry",country);
    }

    @Override
    public void insertCountry(Country country) {
        getSession().insert("country.insertCountry",country);
    }
}
