package com.linshuo.graduation.entity;

import java.util.Date;

public class Activity {
    private Date beginDate;
    private Date endDate;
    private String avtivity;


    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAvtivity() {
        return avtivity;
    }

    public void setAvtivity(String avtivity) {
        this.avtivity = avtivity;
    }
}
