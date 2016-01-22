package com.nuc.device.service;

import com.nuc.device.bean.Apply;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:0:48
 */
public interface ApplyService {
    public List<Apply> queryApplyList(Apply apply);
    public Apply queryApplyById(long id);
    public void createApply(Apply apply);
    public void updateApply(Apply apply);
    public void delApply(long id);
}
