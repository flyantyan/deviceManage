package com.nuc.device.test.dao;

import com.nuc.device.bean.DevMaintain;
import com.nuc.device.dao.DevMaintainDao;
import com.nuc.device.test.SpringTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2016/3/5
 * Time:2:28
 */
public class MaintainDaoTest extends SpringTest {
    @Autowired
    private DevMaintainDao devMaintainDao;

    @Test
    public void TestUpdateMaintainStatus(){
        DevMaintain maintain=new DevMaintain();
        maintain.setId(2);
        maintain.setStatus(2);
        maintain.setModifyEmpId(1);
        devMaintainDao.updateMaintainStatus(maintain);
    }
    @Test
    public void TestQueryMaintainById(){
        Assert.assertNotNull(devMaintainDao.queryMaintainById(Long.valueOf("2")));
    }
}
