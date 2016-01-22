package com.nuc.device.base.dao.impl;

import com.nuc.device.base.BaseDao;
import com.nuc.device.base.bean.Deposit;
import com.nuc.device.base.dao.DevDepositDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:23:59
 */
@Repository
public class DevDepositDaoImpl extends BaseDao implements DevDepositDao {
    @Override
    public List<Deposit> queryDepositList() {
        return getSession().selectList("deposit.queryDepositList");
    }

    @Override
    public Deposit queryDepositById(Long id) {
        return getSession().selectOne("deposit.queryDepositById",id);
    }

    @Override
    public void updateDeposit(Deposit deposit) {
        getSession().update("deposit.updateDeposit",deposit);
    }

    @Override
    public void delDeposit(Deposit deposit) {
        getSession().update("deposit.delDeposit",deposit);
    }

    @Override
    public void insertDeposit(Deposit deposit) {
        getSession().insert("deposit.insertDeposit",deposit);
    }
}
