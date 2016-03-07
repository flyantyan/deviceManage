package com.nuc.device.util.model;

import java.util.List;

/**
 * Created by guoqiang on 2015/11/26.
 */
public class ThreadInfo {
    private String name;
    private String state;
    private String group;
    private List<String> stack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }
}
