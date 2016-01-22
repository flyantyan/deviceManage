package com.nuc.device.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.bean.DevDump;
import com.nuc.device.dao.DevDumpDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:36
 */
@Repository
public class DevDumpDaoImpl extends BaseDao implements DevDumpDao {
    @Override
    public List<DevDump> queryDumpList(DevDump dump) {
        return getSession().selectList("dump.queryDumpList",dump);
    }

    @Override
    public int queryDumpNumByDevId(Long id) {
        Object value=getSession().selectOne("dump.queryDumpNumByDevId",id);
        return value==null?0:(Integer)value;
    }

    @Override
    public DevDump queryDumpById(Long id) {
        return getSession().selectOne("dump.queryDumpById", id);
    }

    @Override
    public void insertDump(DevDump dump) {
        getSession().insert("dump.insertDump",dump);
    }
}
