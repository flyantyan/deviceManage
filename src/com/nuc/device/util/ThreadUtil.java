package com.nuc.device.util;


import com.nuc.device.util.model.ThreadInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Created by guoqiang on 2015/06/02.
 */
public final class ThreadUtil {

    public static final int THREAD_POOL_COUNT = 5;

    public static void shutdownAndWaitRunOver(ExecutorService executor) {
        shutdownAndWaitRunOver(executor, 10);
    }

    public static List<ThreadInfo> getAllThreadInfo() {
        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        List<ThreadInfo> list = new ArrayList<ThreadInfo>(threadMap.size());
        for (Thread thread : threadMap.keySet()) {
            ThreadInfo info = new ThreadInfo();
            info.setName(thread.getName() + "-" + thread.getId());
            info.setGroup(thread.getThreadGroup().getName());
            info.setState(thread.getState().name());
            info.setStack(StringTools.getCurrentStackList(threadMap.get(thread)));
            list.add(info);
        }
        return list;
    }

    /**
     * 停止线程池,并等待线程池中的任务跑完
     *
     * @param executor
     * @param time
     */
    public static void shutdownAndWaitRunOver(ExecutorService executor, long time) {
        executor.shutdown();
        while (!executor.isTerminated()) {
            sleep(time);
        }
    }

    public static InterruptedException sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            return e;
        }
        return null;
    }

    /**
     * 获取堆栈中clazz以上的一个
     * @param stackTrace
     * @param clazz
     * @return
     */
    public static StackTraceElement getLastStackTraceElement(StackTraceElement[] stackTrace, Class clazz) {
        for (StackTraceElement element : stackTrace) {
            if (!element.getClassName().equals(clazz.getName())) {
                return element;
            }
        }
        if (stackTrace.length > 0) {
            return stackTrace[0];
        }
        return null;
    }
}
