package com.nuc.device.dao;

import com.nuc.device.bean.Apply;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/26
 * Time:0:17
 */
public interface ApplyDao {
    public List<Apply> queryApplyList(Apply apply);
    public Long insertApply(Apply apply);
    public void updateApply(Apply apply);
    public void delApply(Apply apply);
    public Apply queryApplyById(Long id);
    public int queryLendNumByDevId(Long id);
    public int queryLendNum();
}
