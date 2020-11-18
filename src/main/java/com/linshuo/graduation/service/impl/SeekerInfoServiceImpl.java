package com.linshuo.graduation.service.impl;

import com.linshuo.graduation.dao.RecruimentDao;
import com.linshuo.graduation.dao.SeekerInfoDao;
import com.linshuo.graduation.entity.*;
import com.linshuo.graduation.service.RecruitmentService;
import com.linshuo.graduation.service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeekerInfoServiceImpl implements SeekerInfoService {
    @Autowired
    private SeekerInfoDao seekerInfoDao;


    //  增
    @Override
    public void addMainInfo(MainInfo x) {
        seekerInfoDao.saveMainInfo(x);
    }

    @Override
    public void addAwardInfo(AwardInfo x) {
        seekerInfoDao.saveAwardInfo(x);
    }

    @Override
    public void addSkillInfo(SkillInfo x) {
        seekerInfoDao.saveSkillInfo(x);
    }

    @Override
    public void addWorkExpInfo(WorkExpInfo x) {
        seekerInfoDao.saveWorkExpInfo(x);
    }

    @Override
    public void addEduExpInfo(EduExpInfo x) {
        seekerInfoDao.saveEduExpInfo(x);
    }

    @Override
    public void addCourseInfo(CourseInfo x) {
        seekerInfoDao.saveCourseInfo(x);
    }

    @Override
    public void addActivityInfo(ActivityInfo x) {
        seekerInfoDao.saveActivityInfo(x);
    }

    @Override
    public void addSelfEvaluation(SelfEvaluation x) {
        seekerInfoDao.saveSelfEvaluation(x);
    }


//    查
    @Override
    public MainInfo findMainInfo(String id) {
        return seekerInfoDao.findMainInfo(id);
    }

    @Override
    public AwardInfo findAwardInfo(String id) {
        return (AwardInfo) seekerInfoDao.findAwardInfo(id);
    }

    @Override
    public SkillInfo findSkillInfo(String id) {
        return seekerInfoDao.findSkillInfo(id);
    }

    @Override
    public WorkExpInfo findWorkExpInfo(String id) {
        return seekerInfoDao.findWorkExpInfo(id);
    }

    @Override
    public EduExpInfo findEduExpInfo(String id) {
        return seekerInfoDao.findEduExpInfo(id);
    }

    @Override
    public CourseInfo findCourseInfo(String id) {
        return seekerInfoDao.findCourseInfo(id);
    }

    @Override
    public ActivityInfo findActivityInfo(String id) {
        return seekerInfoDao.findActivityInfo(id);
    }

    @Override
    public SelfEvaluation findSelfEvaluation(String id) {
        return seekerInfoDao.findSelfEvaluation(id);
    }

//    改
    @Override
    public void updateMainInfo(MainInfo x) {
        seekerInfoDao.updateMainInfo(x);
    }

    @Override
    public void updateAwardInfo(AwardInfo x) {
        seekerInfoDao.updateAwardInfo(x);
    }

    @Override
    public void updateSkillInfo(SkillInfo x) {
        seekerInfoDao.updateSkillInfo(x);
    }

    @Override
    public void updateWorkExpInfo(WorkExpInfo x) {
        seekerInfoDao.updateWorkExpInfo(x);
    }

    @Override
    public void updateEduExpInfo(EduExpInfo x) {
        seekerInfoDao.updateEduExpInfo(x);
    }

    @Override
    public void updateCourseInfo(CourseInfo x) {
        seekerInfoDao.updateCourseInfo(x);
    }

    @Override
    public void updateActivityInfo(ActivityInfo x) {
        seekerInfoDao.updateActivityInfo(x);
    }

    @Override
    public void updateSelfEvaluation(SelfEvaluation x) {
        seekerInfoDao.updateSelfEvaluation(x);
    }

//    查所有
    @Override
    public List<SelfEvaluation> findAll() {
        return seekerInfoDao.findAll();
    }


//搜索

    @Override
    public List<MainInfo> searchSeeker(String words) {
        return seekerInfoDao.searchSeeker(words); }
//        删除
    @Override
    public void deleteData(String id) {
        seekerInfoDao.deleteMainInfo(id);
        seekerInfoDao.deleteSkillInfo(id);
        seekerInfoDao.deleteAwardInfo(id);
        seekerInfoDao.deleteEduExpInfo(id);
        seekerInfoDao.deleteActivityInfo(id);
        seekerInfoDao.deleteCourseInfo(id);
        seekerInfoDao.deleteSelfEvaluation(id);
        seekerInfoDao.deleteWorkExpInfo(id);
    }
}
