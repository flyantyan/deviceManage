package com.nuc.device.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.nuc.device.base.BaseBean;
import java.util.Date;
/**
 * 设备报废信息
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/25
 * Time:1:30
 */
public class DevDump extends BaseBean {
    public static final String DUMP_DAMAGE="已损坏";
    public static final String DUMP_NOTMAINTAIN="无法维修";
    public static final String DUMP_DEADLINE="已到期";
    private String dumpNo;//报废编号
    private long devId;//报废设备id
    private String devName;//设备名称
    private int dumpNum;//报废数量
    private Integer dumpReason;//报废原因id
    private String dumpReasonDesc;//报废原因
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date dumpTime;//报废时间
    private String dumpEmp;//报废人
    private String remark;//备注

    public String getDumpNo() {
        return dumpNo;
    }

    public void setDumpNo(String dumpNo) {
        this.dumpNo = dumpNo;
    }

    public long getDevId() {
        return devId;
    }

    public void setDevId(long devId) {
        this.devId = devId;
    }

    public int getDumpNum() {
        return dumpNum;
    }

    public void setDumpNum(int dumpNum) {
        this.dumpNum = dumpNum;
    }

    public Integer getDumpReason() {
        return dumpReason;
    }

    public void setDumpReason(Integer dumpReason) {
        switch (dumpReason){
            case 1:this.setDumpReasonDesc(DUMP_DAMAGE);
                break;
            case 2:this.setDumpReasonDesc(DUMP_NOTMAINTAIN);
                break;
            case 3:this.setDumpReasonDesc(DUMP_DEADLINE);
                break;
            default:break;
        }
        this.dumpReason = dumpReason;
    }

    public Date getDumpTime() {
        return dumpTime;
    }

    public void setDumpTime(Date dumpTime) {
        this.dumpTime = dumpTime;
    }

    public String getDumpEmp() {
        return dumpEmp;
    }
    public void setDumpEmp(String dumpEmp) {
        this.dumpEmp = dumpEmp;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDumpReasonDesc() {
        return dumpReasonDesc;
    }

    public void setDumpReasonDesc(String dumpReasonDesc) {
        this.dumpReasonDesc = dumpReasonDesc;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }
}
