package com.nuc.device.test.dao;

import com.nuc.device.bean.Apply;
import com.nuc.device.dao.ApplyDao;
import com.nuc.device.test.SpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2016/3/5
 * Time:21:07
 */
public class ApplyDaoTest extends SpringTest {
    @Autowired
    private ApplyDao applyDao;

    @Test
    public void TestInsertApply(){
        Apply apply=new Apply();
        apply.setApplyNo("ceshi010");
        apply.setStatus(1);
        Long re=applyDao.insertApply(apply);
        System.out.println(re);
    }
}
