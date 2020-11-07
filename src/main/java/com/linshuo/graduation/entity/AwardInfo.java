package com.linshuo.graduation.entity;

import java.util.List;

public class AwardInfo {
    private String openId;
    private List<Award> awards;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<Award> getAwards() {
        return awards;
    }

    public void setAwards(List<Award> awards) {
        this.awards = awards;
    }
}
