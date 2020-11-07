package com.linshuo.graduation.entity;

import java.util.List;

public class WorkExpInfo {
    private String openId;
    private List<WorkExp> workExps;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<WorkExp> getWorkExps() {
        return workExps;
    }

    public void setWorkExps(List<WorkExp> workExps) {
        this.workExps = workExps;
    }
}
