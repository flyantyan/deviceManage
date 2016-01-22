package com.nuc.device.base.dao;

import com.nuc.device.base.bean.Deposit;

import java.util.List;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/12/16
 * Time:23:58
 */
public interface DevDepositDao {
    public List<Deposit> queryDepositList();
    public Deposit queryDepositById(Long id);
    public void updateDeposit(Deposit deposit);
    public void delDeposit(Deposit deposit);
    public void insertDeposit(Deposit deposit);
}
