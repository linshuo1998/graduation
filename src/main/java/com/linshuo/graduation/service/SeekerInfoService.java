package com.linshuo.graduation.service;

import com.linshuo.graduation.entity.*;

import java.util.List;

public interface SeekerInfoService {

    //    添加对象
    public void addMainInfo(MainInfo x);

    public void addAwardInfo(AwardInfo x);

    public void addSkillInfo(SkillInfo x);

    public void addWorkExpInfo(WorkExpInfo x);

    public void addEduExpInfo(EduExpInfo x);

    public void addCourseInfo(CourseInfo x);

    public void addActivityInfo(ActivityInfo x);

    public void addSelfEvaluation(SelfEvaluation x);

    //    查询对象
    public MainInfo findMainInfo(String id);
    public AwardInfo findAwardInfo(String id);
    public SkillInfo findSkillInfo(String id);
    public WorkExpInfo findWorkExpInfo(String id);
    public EduExpInfo findEduExpInfo(String id);
    public CourseInfo findCourseInfo(String id);
    public ActivityInfo findActivityInfo(String id);
    public SelfEvaluation findSelfEvaluation(String id);




    //    修改对象
    public void updateMainInfo(MainInfo x);
    public void updateAwardInfo(AwardInfo x);
    public void updateSkillInfo(SkillInfo x);
    public void updateWorkExpInfo(WorkExpInfo x);
    public void updateEduExpInfo(EduExpInfo x);
    public void updateCourseInfo(CourseInfo x);
    public void updateActivityInfo(ActivityInfo x);
    public void updateSelfEvaluation(SelfEvaluation x);


    //    查询所有
    public List<SelfEvaluation> findAll();


    //    删除对象
//    public void deleteData(String id);
}
