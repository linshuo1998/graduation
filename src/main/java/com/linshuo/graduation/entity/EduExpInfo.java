package com.linshuo.graduation.entity;

import java.util.List;

public class EduExpInfo {
    private String openId;
    private List<EduExp> eduExps;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<EduExp> getEduExps() {
        return eduExps;
    }

    public void setEduExps(List<EduExp> eduExps) {
        this.eduExps = eduExps;
    }
}
