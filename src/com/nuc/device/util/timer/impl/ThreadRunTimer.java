package com.nuc.device.util.timer.impl;

/**
 * Created by leopold on 2015/7/6.
 */
public class ThreadRunTimer extends RunTimerImpl {
    private ThreadLocal<Long> time = new ThreadLocal<Long>();

    public ThreadRunTimer(String name) {
        super(name);
    }

    @Override
    public final boolean isRun() {
        return time.get() != null;
    }

    @Override
    public boolean start() {
        time.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public boolean stop() {
        if (this.isRun()) {
            synchronized (this) {
                this.overOnce(System.currentTimeMillis() - time.get());
                time.remove();
            }
        }
        return false;
    }
}
