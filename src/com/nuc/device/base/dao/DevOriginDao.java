package com.nuc.device.base.dao;

import com.nuc.device.base.bean.Origin;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:20:34
 */
public interface DevOriginDao {
    public List<Origin> queryOriginList();
    public Origin queryOriginById(Long id);
    public void updateOrigin(Origin origin);
    public void delOrigin(Origin origin);
    public void insertOrigin(Origin origin);
}
