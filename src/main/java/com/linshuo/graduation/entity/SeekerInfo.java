package com.linshuo.graduation.entity;


import java.util.List;

public class SeekerInfo {
    private String openId;
    //mainInfo
    private MainInfo mainInfo;
    //selfEvaluation
    private String selfEvaluation;
//    //awards
//    private List<Award> awards;
//    //skills
//    private List<Skill> skills;
    //workExps
    private List<WorkExp> workExps;
//    //eduExps
//    private List<EduExp> eduExps;
//    //courses
//    private List<Course> courses;
//    //activities
//    private List<Activity> activities;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

//    public List<Award> getAwards() {
//        return awards;
//    }
//
//    public void setAwards(List<Award> awards) {
//        this.awards = awards;
//    }
//
//    public List<Skill> getSkills() {
//        return skills;
//    }
//
//    public void setSkills(List<Skill> skills) {
//        this.skills = skills;
//    }
//
    public List<WorkExp> getWorkExps() {
        return workExps;
    }

    public void setWorkExps(List<WorkExp> workExps) {
        this.workExps = workExps;
    }
//
//    public List<EduExp> getEduExps() {
//        return eduExps;
//    }
//
//    public void setEduExps(List<EduExp> eduExps) {
//        this.eduExps = eduExps;
//    }
//
//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }
//
//    public List<Activity> getActivities() {
//        return activities;
//    }
//
//    public void setActivities(List<Activity> activities) {
//        this.activities = activities;
//    }
}
