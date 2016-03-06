package com.nuc.device.dao;

import com.nuc.device.bean.ApplyItem;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/27
 * Time:1:27
 */
public interface ApplyItemDao {
    public List<ApplyItem> queryApplyItemList(ApplyItem applyItem);
    public ApplyItem queryApplyItemById(long id);
    public void insetApplyItem(ApplyItem applyItem);
    public void updateApplyItem(ApplyItem applyItem);
    public void delApplyItem(ApplyItem applyItem);
    public List<ApplyItem> queryApplyItemByApplyId(Long applyId);
}
