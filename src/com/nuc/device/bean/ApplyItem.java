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
    private int devNum;//设备数量
    private String remark;//备注
    private long applyId;//申请id
    private String devNo;
    private String devName;
    private String modelNo;
    private String standard;
    private String cateName;
    private String originName;
    private String direcName;
    private String countryName;

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


    public int getDevNum() {
        return devNum;
    }

    public void setDevNum(int devNum) {
        this.devNum = devNum;
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

    public String getDevNo() {
        return devNo;
    }

    public void setDevNo(String devNo) {
        this.devNo = devNo;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDirecName() {
        return direcName;
    }

    public void setDirecName(String direcName) {
        this.direcName = direcName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
