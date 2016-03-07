package com.nuc.device.util.timer;

/**
 * Created by leopold on 2015/7/6.
 * 时间计时器
 */
public interface RunTimer {

    /**
     * 时间计时器的名称
     *
     * @return
     */
    String getName();

    /**
     * 是否正在计时
     *
     * @return
     */
    boolean isRun();

    /**
     * 开始计时
     * 返回是否正确执行开始计时
     *
     * @return
     */
    boolean start();

    /**
     * 结束本次计时
     * 返回是否正确执行结束计时
     *
     * @return
     */
    boolean stop();

    /**
     * 执行次数
     *
     * @return
     */
    long getCount();

    /**
     * 总共运行时间
     *
     * @return
     */
    long getTotalTime();

    /**
     * 最小执行时间
     *
     * @return
     */
    Long getMinTime();

    /**
     * 最大执行时间
     *
     * @return
     */
    Long getMaxTime();

    /**
     * 平均时间
     *
     * @return
     */
    long getAvgTime();
}
