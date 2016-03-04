package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.Apply;
import com.nuc.device.dao.ApplyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/10
 * Time:22:42
 */
@Repository
public class ApplyDaoImpl extends BaseDao implements ApplyDao{
    private final static Logger logger= LoggerFactory.getLogger(ApplyDaoImpl.class);
    @Override
    public List<Apply> queryApplyList(Apply apply) {
        return getSession().selectList("apply.queryApplyList",apply);
    }

    @Override
    public Apply insertApply(Apply apply) {
        return null;
    }

    @Override
    public void upateApply(Apply apply) {

    }

    @Override
    public void delApply(Apply apply) {

    }

    @Override
    public Apply queryApplyById(Long id) {
        return null;
    }

    @Override
    public int queryLendNumByDevId(Long id) {
        Object value=getSession().selectOne("apply.queryLendNumByDevId",id);
        return value==null?0:(Integer)value;
    }

    @Override
    public int queryLendNum() {
        return getSession().selectOne("apply.queryLendNum");
    }

}
