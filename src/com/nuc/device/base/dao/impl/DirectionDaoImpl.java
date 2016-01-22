package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Direction;
import com.nuc.device.base.dao.DirectionDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/17
 * Time:0:09
 */
@Repository
public class DirectionDaoImpl extends BaseDao implements DirectionDao {
    @Override
    public List<Direction> queryDirectionList() {
        return getSession().selectList("direction.queryDirectionList");
    }

    @Override
    public Direction queryDirectionById(Long id) {
        return getSession().selectOne("direction.queryDirectionById",id);
    }

    @Override
    public void updateDirection(Direction direction) {
        getSession().update("direction.updateDirection",direction);
    }

    @Override
    public void delDirection(Direction direction) {
        getSession().update("direction.delDirection",direction);
    }

    @Override
    public void insertDirection(Direction direction) {
        getSession().insert("direction.insertDirection",direction);
    }
}
