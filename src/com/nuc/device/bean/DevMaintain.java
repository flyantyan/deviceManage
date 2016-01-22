package com.nuc.device.bean;

import com.nuc.device.base.BaseBean;

/**
 * 设备维修信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:34
 */
public class DevMaintain extends BaseBean{
    public static final String MAINTAIN_APPLY="申请维修";
    public static final String MAINTAIN_ING="维修中";
    public static final String MAINTAIN_FINISH="维修完成";
    private String maintainNo;//维修编号
    private long devId;//设备id
    private String devName;//设备名称
    private int maintainNum;//维修数量
    private int status;//状态
    private String statusDesc;//状态描述
    private String remark;//备注
    private String maintainEmp;//维修负责人

    public String getMaintainNo() {
        return maintainNo;
    }

    public void setMaintainNo(String maintainNo) {
        this.maintainNo = maintainNo;
    }

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public int getMaintainNum() {
        return maintainNum;
    }

    public void setMaintainNum(int maintainNum) {
        this.maintainNum = maintainNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getMaintainEmp() {
        return maintainEmp;
    }

    public void setMaintainEmp(String maintainEmp) {
        this.maintainEmp = maintainEmp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        switch (status){
            case 1:this.setStatusDesc(MAINTAIN_APPLY);
                break;
            case 2:this.setStatusDesc(MAINTAIN_ING);
                break;
            case 3:this.setStatusDesc(MAINTAIN_FINISH);
                break;
            default:break;
        }
        this.status = status;
    }
}
