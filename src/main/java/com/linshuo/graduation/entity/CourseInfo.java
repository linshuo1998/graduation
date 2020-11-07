package com.linshuo.graduation.entity;

import java.util.List;

public class CourseInfo {
    private String openId;
    private List<Course> courses;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
