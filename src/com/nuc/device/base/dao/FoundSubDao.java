package com.nuc.device.base.dao;

import com.nuc.device.base.bean.FoundSub;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/17
 * Time:0:04
 */
public interface FoundSubDao {
    public List<FoundSub> queryFoundSubList();
    public FoundSub queryFoundSubById(Long id);
    public void updateFoundSub(FoundSub sub);
    public void delFoundSub(FoundSub sub);
    public void insertFoundSub(FoundSub sub);
}
