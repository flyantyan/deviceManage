package com.nuc.device.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.nuc.device.base.poi.annotation.ExcelColumnName;

import java.util.Date;

/**
 * Created by IDEA
 * User:Leopold
 * Email:ylp_boy@126.com
 * Date:2015/11/24
 * Time:0:54
 */
public class BaseBean  {
    private long id;    //id
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;//创建时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date modifyTime;//最后修改时间
    private long createEmpId;//创建人id
    private long modifyEmpId;//最后修改人id
    private String createEmpName;//创建人姓名
    private String modifyEmpName;//最后修改人姓名

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public long getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(long createEmpId) {
        this.createEmpId = createEmpId;
    }

    public long getModifyEmpId() {
        return modifyEmpId;
    }

    public void setModifyEmpId(long modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    public String getCreateEmpName() {
        return createEmpName;
    }

    public void setCreateEmpName(String createEmpName) {
        this.createEmpName = createEmpName;
    }

    public String getModifyEmpName() {
        return modifyEmpName;
    }

    public void setModifyEmpName(String modifyEmpName) {
        this.modifyEmpName = modifyEmpName;
    }
}
