package com.nuc.device.service.impl;

import com.nuc.device.base.bean.*;
import com.nuc.device.bean.DevInfo;
import com.nuc.device.dao.ApplyDao;
import com.nuc.device.dao.DevDumpDao;
import com.nuc.device.dao.DevInfoDao;
import com.nuc.device.dao.DevMaintainDao;
import com.nuc.device.service.DevInfoService;
import com.nuc.device.util.BuildSerialNumber;
import com.nuc.device.util.CommonUtil;
import com.nuc.device.util.SystemParamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return devInfo;
    }

    @Override
    public void updateDevInfo(DevInfo devInfo) {
        devInfoDao.updateDevInfo(devInfo);
    }

    @Override
    public void createDevInfo(DevInfo devInfo) {
        devInfo.setDevNo("DE"+ BuildSerialNumber.getSimpleNo(18));
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

    @Override
    public Map<String, Integer> queryDeviceStatus() {
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("devNum",devInfoDao.queryDevInfoCount());
        map.put("applyNum",applyDao.queryLendNum());
        map.put("maintainNum",maintainDao.queryMaintainNum());
        map.put("dumpNum",dumpDao.queryDumpNum());
        return map;
    }

    @Override
    public void devInfoBatchImport(List<DevInfo> list,Long empId) {
        for(DevInfo devInfo:list){
            devInfo.setCreateEmpId(empId);
            devInfo.setModifyEmpId(empId);
            this.warpDevInfo(devInfo);
            this.createDevInfo(devInfo);
        }
    }
    private void warpDevInfo(DevInfo devInfo){
        for(Category cate:SystemParamUtils.getCategoryList()){
            if(cate.getCateName().equals(devInfo.getCateName())){
                devInfo.setCateId(CommonUtil.long2Integer(cate.getId()));
                break;
            }
        }
        for(Origin origin:SystemParamUtils.getOriginList()){
            if(origin.getOriginName().equals(devInfo.getOriginName())){
                devInfo.setOriginId(CommonUtil.long2Integer(origin.getId()));
                break;
            }
        }
        for (Country country:SystemParamUtils.getCountryList()){
            if(country.getCountryName().equals(devInfo.getCountryName())){
                devInfo.setCountryId(CommonUtil.long2Integer(country.getId()));
                break;
            }
        }
        for (Deposit deposit:SystemParamUtils.getDepositList()){
            if (deposit.getDepositName().equals(devInfo.getDepositName())){
                devInfo.setDepositId(CommonUtil.long2Integer(deposit.getId()));
                break;
            }
        }
        for (Direction direction:SystemParamUtils.getDirectionList()){
            if(direction.getDirecName().equals(devInfo.getDirecName())){
                devInfo.setDirecId(CommonUtil.long2Integer(direction.getId()));
                break;
            }
        }
        for (FoundSub foundSub:SystemParamUtils.getFoundSubList()){
            if (foundSub.getFoundName().equals(devInfo.getFoundName())){
                devInfo.setFoundId(CommonUtil.long2Integer(foundSub.getId()));
                break;
            }
        }
    }
}
