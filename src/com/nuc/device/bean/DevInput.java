package com.nuc.device.bean;

import com.nuc.device.base.BaseBean;

import java.util.Date;

/**
 * 设备入库记录信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:22
 */
public class DevInput extends BaseBean {
    private String inputNo;//入库编号
    private String barCode;//设备条形码
    private String devName;//设备名称
    private int cateId;//类别id
    private String cateName;//类别名称
    private String modelNo;//设备型号
    private String standard;//设备规格
    private double price;//设备单价
    private int countryId;//国家id
    private String countryName;//国家名称
    private String firm;//厂商名称
    private String outFirmNo;//出厂编号
    private Date purchaseTime;//购买时间
    private int foundId;//经费科目id
    private String foundName;//经费科目名称
    private int originId;//设备来源id
    private String originName;//设备来源名称
    private int depositId;//设备存放地id
    private String depositName;//设备存放地名称
    private int devSum;//设备数量
    private String remark;//备注
    private long dealEmpId;//入库人id
    private String dealEmpName;//入库人姓名

    public String getInputNo() {
        return inputNo;
    }

    public void setInputNo(String inputNo) {
        this.inputNo = inputNo;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getOutFirmNo() {
        return outFirmNo;
    }

    public void setOutFirmNo(String outFirmNo) {
        this.outFirmNo = outFirmNo;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getFoundId() {
        return foundId;
    }

    public void setFoundId(int foundId) {
        this.foundId = foundId;
    }

    public String getFoundName() {
        return foundName;
    }

    public void setFoundName(String foundName) {
        this.foundName = foundName;
    }

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public int getDepositId() {
        return depositId;
    }

    public void setDepositId(int depositId) {
        this.depositId = depositId;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public int getDevSum() {
        return devSum;
    }

    public void setDevSum(int devSum) {
        this.devSum = devSum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDealEmpName() {
        return dealEmpName;
    }

    public void setDealEmpName(String dealEmpName) {
        this.dealEmpName = dealEmpName;
    }

    public long getDealEmpId() {
        return dealEmpId;
    }

    public void setDealEmpId(long dealEmpId) {
        this.dealEmpId = dealEmpId;
    }
}
