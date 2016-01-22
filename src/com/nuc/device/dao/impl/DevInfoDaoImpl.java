package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.dao.DevInfoDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:14:09
 */
@Repository
public class DevInfoDaoImpl extends BaseDao implements DevInfoDao{
    @Override
    public List<DevInfo> queryDevInfo(DevInfo devInfo) {
        return getSession().selectList("devInfo.queryDevInfo",devInfo);
    }

    @Override
    public DevInfo queryDevInfoById(Long id) {
        return getSession().selectOne("devInfo.queryDevInfoById",id);
    }

    @Override
    public void updateDevInfo(DevInfo devInfo) {
        getSession().update("devInfo.updateDevInfo",devInfo);
    }

    @Override
    public void delDevInfo(DevInfo devInfo) {

    }

    @Override
    public void createDevInfo(DevInfo devInfo) {
        getSession().insert("devInfo.createDevInfo",devInfo);
    }
}
