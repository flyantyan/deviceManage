package com.nuc.device.bean;

import com.nuc.device.base.BaseBean;
import java.util.Date;
/**
 * 设备申请项
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:0:42
 */
public class ApplyItem extends BaseBean {
    private String itemNo;//申请项编号
    private long devId;//设备id
    private String devUnit;//设备单位
    private int devNum;//设备数量
    private Date useTime;//使用时间
    private int direcId;//使用方向id
    private String direcName;//使用方向名称
    private String devLab;//实验室
    private String remark;//备注
    private long applyId;//申请id

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public String getDevUnit() {
        return devUnit;
    }

    public void setDevUnit(String devUnit) {
        this.devUnit = devUnit;
    }

    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
    }

    public Date getUseTime() {
        return useTime;
    }

    public void setUseTime(Date useTime) {
        this.useTime = useTime;
    }

    public int getDirecId() {
        return direcId;
    }

    public void setDirecId(int direcId) {
        this.direcId = direcId;
    }

    public String getDirecName() {
        return direcName;
    }

    public void setDirecName(String direcName) {
        this.direcName = direcName;
    }

    public String getDevLab() {
        return devLab;
    }

    public void setDevLab(String devLab) {
        this.devLab = devLab;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getApplyId() {
        return applyId;
    }

    public void setApplyId(long applyId) {
        this.applyId = applyId;
    }
}
