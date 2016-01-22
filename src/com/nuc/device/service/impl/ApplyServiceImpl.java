package com.nuc.device.service.impl;

import com.nuc.device.bean.Apply;
import com.nuc.device.dao.ApplyDao;
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
    public void createApply(Apply apply) {
        apply.setApplyNo(BuildSerialNumber.getSimpleNo(20));
        applyDao.insertApply(apply);
    }

    @Override
    @Transactional
    public void updateApply(Apply apply) {
        applyDao.upateApply(apply);
    }

    @Override
    @Transactional
    public void delApply(long id) {
        Apply apply=new Apply();
        applyDao.delApply(apply);
    }
}
