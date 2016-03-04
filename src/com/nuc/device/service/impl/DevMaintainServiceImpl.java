package com.nuc.device.service.impl;

import com.nuc.device.bean.DevMaintain;
import com.nuc.device.dao.DevMaintainDao;
import com.nuc.device.service.DevMaintainService;
import com.nuc.device.util.BuildSerialNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:42
 */
@Service
public class DevMaintainServiceImpl implements DevMaintainService {
    @Autowired
    private DevMaintainDao maintainDao;
    @Override
    public List<DevMaintain> queryMaintainList(DevMaintain maintain) {
        return maintainDao.queryMaintainList(maintain);
    }

    @Override
    public void createMaintain(DevMaintain maintain) {
        maintain.setStatus(1);
        maintain.setMaintainNo("MT"+BuildSerialNumber.getSimpleNo(18));
        maintainDao.createMaintain(maintain);
    }

    @Override
    public void updateMaintainStatus(DevMaintain maintain) {
        maintainDao.updateMaintainStatus(maintain);
    }

    @Override
    public DevMaintain queryMaintainById(Long id) {
        return maintainDao.queryMaintainById(id);
    }

}
