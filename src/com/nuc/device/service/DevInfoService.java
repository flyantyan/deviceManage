package com.nuc.device.service;

import com.nuc.device.bean.DevInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:14:27
 */
public interface DevInfoService {
    public List<DevInfo> queryDevInfo(DevInfo devInfo);
    public DevInfo queryDevInfoById(Long id);
    public void updateDevInfo(DevInfo devInfo);
    public void createDevInfo(DevInfo devInfo);
    public DevInfo queryDevInfoByNo(String devNo);
    public Map<String,Integer> queryDeviceStatus();
}
