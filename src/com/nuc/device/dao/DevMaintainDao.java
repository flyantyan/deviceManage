package com.nuc.device.dao;

import com.nuc.device.bean.DevMaintain;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/20
 * Time:17:34
 */
public interface DevMaintainDao {
    public List<DevMaintain> queryMaintainList(DevMaintain maintain);
    public int queryMaintainNumByDevId(Long id);
}
