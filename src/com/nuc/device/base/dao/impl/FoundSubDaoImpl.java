package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.FoundSub;
import com.nuc.device.base.dao.FoundSubDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/17
 * Time:0:05
 */
@Repository
public class FoundSubDaoImpl extends BaseDao implements FoundSubDao {
    @Override
    public List<FoundSub> queryFoundSubList() {
        return getSession().selectList("foundSub.queryFoundSubList");
    }

    @Override
    public FoundSub queryFoundSubById(Long id) {
        return getSession().selectOne("foundSub.queryFoundSubById",id);
    }

    @Override
    public void updateFoundSub(FoundSub sub) {
        getSession().update("foundSub.updateFoundSub",sub);
    }

    @Override
    public void delFoundSub(FoundSub sub) {
        getSession().update("foundSub.delFoundSub",sub);
    }

    @Override
    public void insertFoundSub(FoundSub sub) {
        getSession().insert("foundSub.insertFoundSub",sub);
    }
}
