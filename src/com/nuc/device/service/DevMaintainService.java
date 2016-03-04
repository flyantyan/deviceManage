package com.nuc.device.service;

import com.nuc.device.bean.DevMaintain;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:40
 */
public interface DevMaintainService {
    public List<DevMaintain> queryMaintainList(DevMaintain maintain);
    public void createMaintain(DevMaintain maintain);
    public void updateMaintainStatus(DevMaintain maintain);
    public DevMaintain queryMaintainById(Long id);
}
