package com.nuc.device.util.timer;

import com.alibaba.fastjson.JSON;
import com.nuc.device.util.StringTools;
import com.nuc.device.util.timer.impl.CommonRunTimer;
import com.nuc.device.util.timer.impl.ThreadRunTimer;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by leopold on 2015/7/6.
 */
public final class RunTimerMgr {
    private static final RunTimerMgr ME = new RunTimerMgr();
    private final ConcurrentHashMap<String, RunTimer> map = new ConcurrentHashMap<String, RunTimer>(64);
    private static final boolean threadSwitch = true;//默认使用哪种时间计时器
    private static final int PRINTLN_INTERVAL = 3 * 60 * 1000;//打印时间间隔
    private volatile long lastPrintTime = System.currentTimeMillis();

    /**
     * 判断是否可以去打印数据
     * @return
     */
    public boolean toPrint() {
        long now = System.currentTimeMillis();
        if (lastPrintTime + PRINTLN_INTERVAL < now) {
            synchronized (this) {
                if (lastPrintTime + PRINTLN_INTERVAL < now) {
                    lastPrintTime = System.currentTimeMillis();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将运行时输出为json格式
     * @return
     */
    public String toString() {
        String result;
        try {
            result = JSON.toJSONString(map, true);
        } catch (RuntimeException e) {
            result = StringTools.toString(e);
        }
        return result;
    }


    /**
     * 是一个时间运行器开始计时
     * @param name
     * @return
     */
    public boolean start(String name) {
        RunTimer runTimer = get(name);
        if (runTimer == null) {
            if (threadSwitch) {
                runTimer = new ThreadRunTimer(name);
            } else {
                runTimer = new CommonRunTimer(name);
            }
            RunTimer temp = map.putIfAbsent(name, runTimer);
            if (temp != null) {
                runTimer = temp;
            }
        }
        return runTimer.start();
    }

    /**
     * 使一个时间计时器停止计时
     * @param name
     * @return
     */
    public boolean stop(String name) {
        RunTimer runTimer = get(name);
        return runTimer != null && runTimer.stop();
    }

    public void clear() {
        map.clear();
    }

    public RunTimer get(String name) {
        return map.get(name);
    }

    public static RunTimerMgr getMe() {
        return ME;
    }

    private RunTimerMgr() {

    }
}
