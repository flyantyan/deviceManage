package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.DevMaintain;
import com.nuc.device.dao.DevMaintainDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:38
 */
@Repository
public class DevMaintainDaoImpl extends BaseDao implements DevMaintainDao {
    @Override
    public List<DevMaintain> queryMaintainList(DevMaintain maintain) {
        return getSession().selectList("maintain.queryMaintainList",maintain);
    }

    @Override
    public int queryMaintainNumByDevId(Long id) {
        Object value=getSession().selectOne("maintain.queryMaintainNumByDevId",id);
        return value==null?0:(Integer)value;
    }

    @Override
    public int queryMaintainNum() {
        return getSession().selectOne("maintain.queryMaintainNum");
    }

    @Override
    public void createMaintain(DevMaintain maintain) {
        getSession().insert("maintain.createMaintain",maintain);
    }

    @Override
    public void updateMaintainStatus(DevMaintain maintain) {
        getSession().update("maintain.updateMaintainStatus",maintain);
    }

    @Override
    public DevMaintain queryMaintainById(Long id) {
        return getSession().selectOne("maintain.queryMaintainById",id);
    }
}
