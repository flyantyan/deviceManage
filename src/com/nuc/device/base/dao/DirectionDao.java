package com.nuc.device.base.dao;

import com.nuc.device.base.bean.Direction;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/17
 * Time:0:09
 */
public interface DirectionDao {
    public List<Direction> queryDirectionList();
    public Direction queryDirectionById(Long id);
    public void updateDirection(Direction direction);
    public void delDirection(Direction direction);
    public void insertDirection(Direction direction);
}
