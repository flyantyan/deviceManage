package com.nuc.device.util.timer.enums;

/**
 * Created by leopold on 2015/12/12.
 */
public enum WorkEnum {
    CREATE_ORDER(800);
    private int timeout;
    private WorkEnum(int timeout){
        this.timeout=timeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
