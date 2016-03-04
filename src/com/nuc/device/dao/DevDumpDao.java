package com.nuc.device.dao;

import com.nuc.device.bean.DevDump;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:34
 */
public interface DevDumpDao {
    public List<DevDump> queryDumpList(DevDump dump);
    public int queryDumpNumByDevId(Long id);
    public DevDump queryDumpById(Long id);
    public void insertDump(DevDump dump);
    public int queryDumpNum();
}
