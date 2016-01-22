package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Origin;
import com.nuc.device.base.dao.DevOriginDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:20:35
 */
@Repository
public class DevOriginDaoImpl extends BaseDao implements DevOriginDao {
    @Override
    public List<Origin> queryOriginList() {
        return getSession().selectList("origin.queryOriginList");
    }

    @Override
    public Origin queryOriginById(Long id) {
        return getSession().selectOne("origin.queryOriginById",id);
    }

    @Override
    public void updateOrigin(Origin origin) {
        getSession().update("origin.updateOrigin",origin);
    }

    @Override
    public void delOrigin(Origin origin) {
        getSession().update("origin.delOrigin",origin);
    }

    @Override
    public void insertOrigin(Origin origin) {
        getSession().insert("origin.insertOrigin",origin);
    }
}
