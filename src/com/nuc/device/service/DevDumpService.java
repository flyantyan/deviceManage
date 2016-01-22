package com.nuc.device.service;

import com.nuc.device.bean.DevDump;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:39
 */
public interface DevDumpService {
    public List<DevDump> queryDumpList(DevDump dump);
    public DevDump queryDumpById(Long id);
    public void createDump(DevDump dump);
}
