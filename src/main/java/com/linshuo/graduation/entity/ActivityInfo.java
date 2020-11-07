package com.linshuo.graduation.entity;

import java.util.List;

public class ActivityInfo {
    private String openId;
    private List<Activity> activities;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
