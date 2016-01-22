package com.nuc.device.service.impl;

import com.nuc.device.bean.DevInfo;
import com.nuc.device.dao.ApplyDao;
import com.nuc.device.dao.DevDumpDao;
import com.nuc.device.dao.DevInfoDao;
import com.nuc.device.dao.DevMaintainDao;
import com.nuc.device.service.DevInfoService;
import com.nuc.device.util.BuildSerialNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:14:27
 */
@Service
public class DevInfoServiceImpl implements DevInfoService {
    @Autowired
    private DevInfoDao devInfoDao;
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private DevMaintainDao maintainDao;
    @Autowired
    private DevDumpDao dumpDao;
    @Override
    public List<DevInfo> queryDevInfo(DevInfo devInfo) {
        return devInfoDao.queryDevInfo(devInfo);
    }

    @Override
    public DevInfo queryDevInfoById(Long id) {
        DevInfo devInfo=devInfoDao.queryDevInfoById(id);
        devInfo.setLendNum(applyDao.queryLendNumByDevId(id));
        devInfo.setMaintainNum(maintainDao.queryMaintainNumByDevId(id));
        devInfo.setDumpNum(dumpDao.queryDumpNumByDevId(id));
        devInfo.setCanApplySum(devInfo.getDevSum()-devInfo.getLendNum()
                               -devInfo.getDumpNum()-devInfo.getMaintainNum());
        return devInfo;
    }

    @Override
    public void updateDevInfo(DevInfo devInfo) {
        devInfoDao.updateDevInfo(devInfo);
    }

    @Override
    public void createDevInfo(DevInfo devInfo) {
        devInfo.setDevNo("DE"+ BuildSerialNumber.getSimpleNo(10));
        devInfoDao.createDevInfo(devInfo);
    }

    @Override
    public DevInfo queryDevInfoByNo(String devNo) {
        DevInfo devInfo=new DevInfo();
        devInfo.setDevNo(devNo);
        List<DevInfo> list=devInfoDao.queryDevInfo(devInfo);
        if(list==null||list.size()==0){
            return null;
        }
        return list.get(0);
    }
}
