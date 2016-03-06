package com.nuc.device.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.nuc.device.base.BaseBean;
import com.nuc.device.base.poi.annotation.ExcelColumnName;

import java.util.Date;
/**
 * 设备申请信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/24
 * Time:0:54
 */
public class Apply extends BaseBean {
    public static final String APPLY_ING="申请中";
    public static final String APPLY_PASS="已审核";
    public static final String APPLY_LOAN="已借出";
    public static final String APPLY_BACK="已归还";
    public static final String APPLY_REFUSE="已拒绝";
    private String applyNo;//申请编号
    private long applyEmpId;//申请人id
    private String applyEmpName;//申请人姓名
    private Integer status;//申请状态
    private Long dealEmpId;//处理人id
    private String dealEmpName;//处理人姓名
    private String remark;//备注
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date applyTime;//申请时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date dealTime;//处理时间
    private String applyText;//申请理由
    private String dealText;//处理意见
    private String statusDesc;//申请状态描述
    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public long getApplyEmpId() {
        return applyEmpId;
    }

    public void setApplyEmpId(long applyEmpId) {
        this.applyEmpId = applyEmpId;
    }

    public String getApplyEmpName() {
        return applyEmpName;
    }

    public void setApplyEmpName(String applyEmpName) {
        this.applyEmpName = applyEmpName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        switch (status){
            case 1:this.setStatusDesc(APPLY_ING);
                break;
            case 2:this.setStatusDesc(APPLY_PASS);
                break;
            case 3:this.setStatusDesc(APPLY_LOAN);
                break;
            case 4:this.setStatusDesc(APPLY_BACK);
                break;
            case -1:this.setStatusDesc(APPLY_REFUSE);
                break;
            default:break;
        }
        this.status = status;
    }

    public Long getDealEmpId() {
        return dealEmpId;
    }

    public void setDealEmpId(Long dealEmpId) {
        this.dealEmpId = dealEmpId;
    }

    public String getDealEmpName() {
        return dealEmpName;
    }

    public void setDealEmpName(String dealEmpName) {
        this.dealEmpName = dealEmpName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public String getApplyText() {
        return applyText;
    }

    public void setApplyText(String applyText) {
        this.applyText = applyText;
    }

    public String getDealText() {
        return dealText;
    }

    public void setDealText(String dealText) {
        this.dealText = dealText;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
