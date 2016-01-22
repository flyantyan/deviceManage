package com.nuc.device.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.nuc.device.base.BaseBean;
import com.nuc.device.base.poi.annotation.ExcelColumnName;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:0:48
 */
public class DevInfo extends BaseBean {
    @ExcelColumnName("设备编号")
    private String devNo;//设备编号
    @ExcelColumnName("设备条形码")
    private String barCode;//设备条形码
    @ExcelColumnName("设备名称")
    private String devName;//设备名称
    private int cateId;//类别id
    @ExcelColumnName("设备类别")
    private String cateName;//类别名称
    @ExcelColumnName("设备型号")
    private String modelNo;//设备型号
    @ExcelColumnName("设备规格")
    private String standard;//设备规格
    @ExcelColumnName("设备单价")
    private double price;//设备单价
    private int countryId;//国家id
    @ExcelColumnName("设备国别")
    private String countryName;//国家名称
    @ExcelColumnName("厂商名称")
    private String firm;//厂商名称
    @ExcelColumnName("出厂编号")
    private String outFirmNo;//出厂编号
    @ExcelColumnName("购买时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date purchaseTime;//购买时间
    private int foundId;//经费科目id
    @ExcelColumnName("经费科目名称")
    private String foundName;//经费科目名称
    private int originId;//设备来源id
    @ExcelColumnName("设备来源名称")
    private String originName;//设备来源名称
    private int depositId;//设备存放地id
    @ExcelColumnName("设备存放地名称")
    private String depositName;//设备存放地名称
    @ExcelColumnName("设备数量")
    private int devSum;//设备数量
    private String remark;//备注
    private int devPower;//设备权限
    @ExcelColumnName("可以申请数量")
    private int canApplySum;//可以申请数量
    private int direcId;
    @ExcelColumnName("使用方向")
    private String direcName;
    private int lendNum;//借出数量
    private int maintainNum;//维修数量
    private int dumpNum;//报废数量
    public String getDevNo() {
        return devNo;
    }

    public void setDevNo(String devNo) {
        this.devNo = devNo;
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

    public int getDevPower() {
        return devPower;
    }

    public void setDevPower(int devPower) {
        this.devPower = devPower;
    }

    public int getCanApplySum() {
        return canApplySum;
    }

    public void setCanApplySum(int canApplySum) {
        this.canApplySum = canApplySum;
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

    public int getLendNum() {
        return lendNum;
    }

    public void setLendNum(int lendNum) {
        this.lendNum = lendNum;
    }

    public int getMaintainNum() {
        return maintainNum;
    }

    public void setMaintainNum(int maintainNum) {
        this.maintainNum = maintainNum;
    }

    public int getDumpNum() {
        return dumpNum;
    }

    public void setDumpNum(int dumpNum) {
        this.dumpNum = dumpNum;
    }
}
