package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.ApplyItem;
import com.nuc.device.dao.ApplyItemDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:35
 */
@Repository
public class ApplyItemDaoImpl extends BaseDao implements ApplyItemDao {
    @Override
    public List<ApplyItem> queryApplyItemList(ApplyItem applyItem) {
        return null;
    }

    @Override
    public ApplyItem queryApplyItemById(long id) {
        return null;
    }

    @Override
    public void insetApplyItem(ApplyItem applyItem) {
        getSession().insert("applyItem.insertApplyItem",applyItem);
    }

    @Override
    public void updateApplyItem(ApplyItem applyItem) {

    }

    @Override
    public void delApplyItem(ApplyItem applyItem) {

    }

    @Override
    public List<ApplyItem> queryApplyItemByApplyId(Long applyId) {
        return getSession().selectList("applyItem.queryApplyItemByApplyId",applyId);
    }
}
