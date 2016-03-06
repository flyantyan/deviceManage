package com.nuc.device.service.impl;

import com.nuc.device.bean.Apply;
import com.nuc.device.bean.ApplyItem;
import com.nuc.device.dao.ApplyDao;
import com.nuc.device.dao.ApplyItemDao;
import com.nuc.device.service.ApplyService;
import com.nuc.device.util.BuildSerialNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:0:49
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyDao applyDao;
    @Autowired
    private ApplyItemDao applyItemDao;
    @Override
    public List<Apply> queryApplyList(Apply apply) {
        return applyDao.queryApplyList(apply);
    }

    @Override
    public Apply queryApplyById(long id) {
        return applyDao.queryApplyById(id);
    }

    @Override
    @Transactional
    public void createApply(Apply apply,List<ApplyItem> list) {
        apply.setApplyNo("AP"+BuildSerialNumber.getSimpleNo(18));
        apply.setStatus(1);
        Long applyId=applyDao.insertApply(apply);
        for (ApplyItem applyItem : list){
            applyItem.setApplyId(applyId);
            applyItem.setItemNo("AI"+BuildSerialNumber.getSimpleNo(18));
            applyItemDao.insetApplyItem(applyItem);
        }
    }

    @Override
    @Transactional
    public void updateApply(Apply apply) {
        applyDao.updateApply(apply);
    }

    @Override
    @Transactional
    public void delApply(long id) {
        Apply apply=new Apply();
        applyDao.delApply(apply);
    }

    @Override
    public List<ApplyItem> queryApplyItemByApplyId(Long applyId) {
        return applyItemDao.queryApplyItemByApplyId(applyId);
    }
}
