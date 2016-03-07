package com.nuc.device.util.timer.impl;

/**
 * Created by leopold on 2015/7/6.
 */
public final class CommonRunTimer extends RunTimerImpl {
    private Long time;

    public CommonRunTimer(String name) {
        super(name);
    }

    @Override
    public boolean isRun() {
        return time != null;
    }

    @Override
    public boolean start() {
        time = System.currentTimeMillis();
        return true;
    }

    @Override
    public boolean stop() {
        if (isRun()) {
            this.overOnce(System.currentTimeMillis() - this.time);
            this.time = null;
            return true;
        }
        return false;
    }
}
