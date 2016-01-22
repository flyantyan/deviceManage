package com.nuc.device.service.impl;

import com.nuc.device.bean.DevDump;
import com.nuc.device.dao.DevDumpDao;
import com.nuc.device.service.DevDumpService;
import com.nuc.device.util.BuildSerialNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:40
 */
@Service
public class DevDumpServiceImpl implements DevDumpService {
    @Autowired
    private DevDumpDao dumpDao;
    @Override
    public List<DevDump> queryDumpList(DevDump dump) {
        return dumpDao.queryDumpList(dump);
    }

    @Override
    public DevDump queryDumpById(Long id) {
        return dumpDao.queryDumpById(id);
    }

    @Override
    public void createDump(DevDump dump) {
        dump.setDumpNo("DE"+ BuildSerialNumber.getSimpleNo(18));
        dumpDao.insertDump(dump);
    }
}
