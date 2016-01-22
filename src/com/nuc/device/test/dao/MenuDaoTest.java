package com.nuc.device.test.dao;

import com.nuc.device.base.dao.MenuDao;
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
public class MenuDaoTest extends SpringTest {
    @Autowired
    MenuDao menuDao;
    @Test
    public void testQueryMenu(){
        menuDao.queryMenuListByIds("1,2,3,4,5");
    }
}
