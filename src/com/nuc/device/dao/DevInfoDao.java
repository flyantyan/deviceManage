package com.nuc.device.dao;

import com.nuc.device.bean.DevInfo;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:14:09
 */
public interface DevInfoDao {
    public List<DevInfo> queryDevInfo(DevInfo devInfo);
    public DevInfo queryDevInfoById(Long id);
    public void updateDevInfo(DevInfo devInfo);
    public void delDevInfo(DevInfo devInfo);
    public void createDevInfo(DevInfo devInfo);
}
