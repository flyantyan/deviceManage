package com.nuc.device.util.timer;


import com.nuc.device.util.CollectionsTools;
import com.nuc.device.util.StringTools;
import com.nuc.device.util.ThreadUtil;
import com.nuc.device.util.timer.enums.WorkEnum;
import com.nuc.device.util.timer.model.WorkSign;
import com.nuc.device.util.timer.model.WorkTimer;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Created by leopold on 2015/12/12.
 */
public final class WorkTimerMgr {

    private static final Map<WorkEnum, ThreadLocal<WorkTimer>> workTimers =
            new ConcurrentHashMap<WorkEnum, ThreadLocal<WorkTimer>>(WorkEnum.values().length * 2);//基于工作类型枚举的线程本地数据存储

    static {
        try {
            init();
        } catch (Exception e) {

        }
    }

    /**
     * 开始记录一个工作类型的数据
     * 一个线程 一个枚举只有一个数据
     *
     * @param workEnum
     * @param remark
     * @return
     */
    public static WorkTimer start(WorkEnum workEnum, Object... remark) {
        try {
            clean(workEnum);
            addWorkTimer(workEnum);
            return run(workEnum, remark);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 结束一个工作时长记录数据
     *
     * @param workEnum
     * @param remark
     * @return
     */
    public static WorkTimer stop(WorkEnum workEnum, Object... remark) {
        try {
            run(workEnum, remark);
            return clean(workEnum);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 记录一次工作时长数据
     *
     * @param workEnum
     * @param remark
     * @return
     */
    public static WorkTimer run(WorkEnum workEnum, Object... remark) {
        try {
            long time = System.currentTimeMillis();
            WorkTimer workTimer = getCurrentWorkTimer(workEnum);
            if (workTimer != null) {
                StackTraceElement element = getCurrentStackTrace();
                workTimer.add(new WorkSign(time, Arrays.toString(remark), element));
            }
            return workTimer;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取当前线程的 该工作枚举的 工作时长记录
     *
     * @param workEnum
     * @return
     */
    public static WorkTimer getCurrentWorkTimer(WorkEnum workEnum) {
        try {
            WorkTimer workTimer;
            ThreadLocal<WorkTimer> threadLocal = workTimers.get(workEnum);
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<WorkTimer>();
                workTimers.put(workEnum, new ThreadLocal<WorkTimer>());
                //TODO  log error
            }
            workTimer = threadLocal.get();
            return workTimer;
        } catch (Exception e) {
            return null;
        }
    }

    public static WorkTimer addWorkTimer(WorkEnum workEnum) {
        WorkTimer workTimer = new WorkTimer();
        try {
            ThreadLocal<WorkTimer> threadLocal = workTimers.get(workEnum);
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<WorkTimer>();
                workTimers.put(workEnum, new ThreadLocal<WorkTimer>());
                //TODO  log error
            }
            threadLocal.remove();
            threadLocal.set(workTimer);
        } catch (Exception e) {
        }
        return workTimer;
    }

    /**
     * 清楚当前工作时长记录数据
     *
     * @param workEnum
     * @return
     */
    public static WorkTimer clean(WorkEnum workEnum) {
        try {
            WorkTimer workTimer = getCurrentWorkTimer(workEnum);
            ThreadLocal<WorkTimer> threadLocal = workTimers.get(workEnum);
            if (threadLocal != null) {
                threadLocal.remove();
            }
            return workTimer;
        } catch (Exception e) {
            return null;
        }
    }

    private static StackTraceElement getCurrentStackTrace() {
        return ThreadUtil.getLastStackTraceElement(new Exception().getStackTrace(), WorkTimerMgr.class);
    }

    public static String getShortDesc(WorkTimer timer) {
        if (timer != null) {
            try {
                StringBuilder builder = new StringBuilder(1024);
                double runTime = timer.getRunTime();
                builder.append("WorkTimer{")
                        .append("runTime=").append(runTime)
                        .append(",startTime=").append(timer.getStartTime())
                        .append(",endTime=").append(timer.getEndTime())
                        .append(",signList=").append("[");
                boolean lastFlag = false;
                double maxRatio = 0;
                if (CollectionsTools.isNotEmpty(timer.getSignList())) {
                    builder.append("\n");
                    maxRatio = 1 / (double)timer.getSignList().size();
                }
                for (WorkSign sign : timer.getSignList()) {
                    boolean flag = false;
                    double ratio = (sign.getRunTime() / runTime);
                    if (ratio >= 0.1 || ratio >= maxRatio) {
                        flag = true;
                    }
                    if (flag || lastFlag) {
                        builder.append("WorkSign{").append("runTime=").append(sign.getRunTime())
                                .append(", \tremark=").append(sign.getRemark()).append(",element=")
                                .append(sign.getElement()).append(",time=").append(sign.getTime())
                                .append("},").append("\n");
                    }
                    lastFlag = flag;
                }
                builder.append("]}");
                return builder.toString();
            } catch (Exception e) {
                return StringTools.toString(e);
            }
        }
        return null;
    }

    private static void init() {
        for (WorkEnum workEnum : WorkEnum.values()) {
            workTimers.put(workEnum, new ThreadLocal<WorkTimer>());
        }
    }

    private WorkTimerMgr() {

    }
}
