package com.nuc.device.util.timer.impl;


import com.nuc.device.util.timer.RunTimer;

/**
 * Created by leopold on 2015/7/6.
 */
public abstract class RunTimerImpl implements RunTimer {
    private final String name;
    private long count;
    private Long maxTime;
    private Long minTime;
    private long totalTime;

    public RunTimerImpl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RunTimer{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", maxTime=" + maxTime +
                ", minTime=" + minTime +
                ", totalTime=" + totalTime +
                '}';
    }

    protected final void overOnce(long currentTime) {
        if (this.maxTime == null || this.maxTime < currentTime) {
            this.maxTime = currentTime;
        }
        if (this.minTime == null || this.minTime > currentTime) {
            this.minTime = currentTime;
        }
        this.count++;
        this.totalTime += currentTime;
    }

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final long getCount() {
        return count;
    }

    @Override
    public final long getTotalTime() {
        return totalTime;
    }

    @Override
    public final Long getMinTime() {
        return minTime;
    }

    @Override
    public final Long getMaxTime() {
        return maxTime;
    }

    @Override
    public final long getAvgTime() {
        return getTotalTime() / getCount();
    }
}
