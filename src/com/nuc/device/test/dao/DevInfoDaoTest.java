package com.nuc.device.test.dao;

import com.nuc.device.dao.DevInfoDao;
import com.nuc.device.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/29
 * Time:3:58
 */
public class DevInfoDaoTest extends SpringTest {
    @Autowired
    DevInfoDao devInfoDao;
    @Test
    public void testQueryDevInfoCount(){
        System.out.println(devInfoDao.queryDevInfoCount());
    }
}
