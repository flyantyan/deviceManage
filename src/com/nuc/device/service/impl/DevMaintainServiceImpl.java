package com.nuc.device.service.impl;

import com.nuc.device.bean.DevMaintain;
import com.nuc.device.dao.DevMaintainDao;
import com.nuc.device.service.DevMaintainService;
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
}
