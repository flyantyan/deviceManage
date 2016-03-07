package com.nuc.device.util.model;

/**
 * Created by guoqiang on 2015/8/7.
 */
public class CommonResult<T> {
    private boolean success;
    private int status;
    private String msg;
    private T value;
    private Throwable e;

    public CommonResult() {
    }

    public CommonResult(boolean success, String msg, T value, Throwable e) {
        this.success = success;
        this.value = value;
        this.msg = msg;

        this.e = e;
    }

    public CommonResult(boolean success, String msg, T value) {
        this.success = success;
        this.msg = msg;
        this.value = value;

    }

    public CommonResult(boolean success, String msg) {

        this.success = success;
        this.msg = msg;
    }

    public T getValue() {

        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Throwable getE() {
        return e;
    }

    public void setE(Throwable e) {
        this.e = e;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
