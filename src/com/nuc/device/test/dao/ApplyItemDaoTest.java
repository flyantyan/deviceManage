package com.nuc.device.test.dao;

import com.nuc.device.bean.ApplyItem;
import com.nuc.device.dao.ApplyItemDao;
import com.nuc.device.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2016/3/6
 * Time:0:17
 */
public class ApplyItemDaoTest extends SpringTest {
    @Autowired
    private ApplyItemDao applyItemDao;

    @Test
    public void insertApplyItemDaoTest(){
        ApplyItem applyItem=new ApplyItem();
        applyItem.setItemNo("ceshi");
        applyItem.setApplyId(2);
        applyItemDao.insetApplyItem(applyItem);
    }
}
