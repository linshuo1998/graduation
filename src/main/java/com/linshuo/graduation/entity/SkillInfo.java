package com.linshuo.graduation.entity;

import java.util.List;

public class SkillInfo {
    private String openId;
    private List<Skill> skills;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
