package com.nuc.device.util.timer.model;

import com.nuc.device.util.CollectionsTools;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leopold on 2015/12/12.
 */
public class WorkTimer {
    private final List<WorkSign> signList = new LinkedList<WorkSign>();
    private long startTime;
    private long endTime;

    public void add(WorkSign sign) {
        if (CollectionsTools.isEmpty(signList)) {
            startTime = sign.getTime();
        } else {
            WorkSign lastSign = signList.get(signList.size() - 1);
            if (lastSign != null) {
                lastSign.setRunTime(sign.getTime() - lastSign.getTime());
            }
        }
        endTime = sign.getTime();
        this.signList.add(sign);
    }

    @Override
    public String toString() {
        return "WorkTimer{" +
                "runTime=" + this.getRunTime() +
                ",startTime=" + startTime +
                ",endTime=" + endTime +
                ",signList=" + signList +
                '}';
    }

    public long getRunTime() {
        return endTime - startTime;
    }

    public List<WorkSign> getSignList() {
        return signList;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
