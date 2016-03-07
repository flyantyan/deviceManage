package com.nuc.device.util.timer.model;

/**
 * Created by leopold on 2015/12/12.
 */
public class WorkSign {
    private long time;
    private String remark;
    private StackTraceElement element;
    private long runTime;

    @Override
    public String toString() {
        return "WorkSign{" +
                "time=" + time +
                ",runTime=" + runTime +
                ",\tremark='" + remark + '\'' +
                ",element=" + element +
                '}';
    }

    public WorkSign(long time, String remark, StackTraceElement element) {
        this.time = time;
        this.remark = remark;
        this.element = element;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public StackTraceElement getElement() {
        return element;
    }

    public void setElement(StackTraceElement element) {
        this.element = element;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public long getRunTime() {
        return runTime;
    }
}
