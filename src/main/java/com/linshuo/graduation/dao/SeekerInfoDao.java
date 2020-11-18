package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class SeekerInfoDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //根据id查询
    public MainInfo findMainInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
//        System.out.println(mongoTemplate.findOne(query, MainInfo.class).getClass());
        return (MainInfo) mongoTemplate.findOne(query, MainInfo.class); 
    }

    public AwardInfo findAwardInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
//        List<AwardInfo> temp = mongoTemplate.find(query, AwardInfo.class);
//        for(int i=0;i<temp.size();i++)
//        {System.out.println(temp.get(i));}
        return (AwardInfo) mongoTemplate.findOne(query, AwardInfo.class);
    }

    public SkillInfo findSkillInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (SkillInfo) mongoTemplate.findOne(query, SkillInfo.class);
    }

    public WorkExpInfo findWorkExpInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (WorkExpInfo) mongoTemplate.findOne(query, WorkExpInfo.class);
    }

    public EduExpInfo findEduExpInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (EduExpInfo) mongoTemplate.findOne(query, EduExpInfo.class);
    }

    public CourseInfo findCourseInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (CourseInfo) mongoTemplate.findOne(query, CourseInfo.class);
    }

    public ActivityInfo findActivityInfo(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (ActivityInfo) mongoTemplate.findOne(query, ActivityInfo.class);
    }

    public SelfEvaluation findSelfEvaluation(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return (SelfEvaluation) mongoTemplate.findOne(query, SelfEvaluation.class);
    }

    //保存对象
    public void saveMainInfo(MainInfo data) {
        mongoTemplate.save(data);
    }

    public void saveAwardInfo(AwardInfo data) {
        mongoTemplate.save(data);
    }

    public void saveSkillInfo(SkillInfo data) {
        mongoTemplate.save(data);
    }

    public void saveWorkExpInfo(WorkExpInfo data) {
        mongoTemplate.save(data);
    }

    public void saveEduExpInfo(EduExpInfo data) {
        mongoTemplate.save(data);
    }

    public void saveCourseInfo(CourseInfo data) {
        mongoTemplate.save(data);
    }

    public void saveActivityInfo(ActivityInfo data) {
        mongoTemplate.save(data);
    }

    public void saveSelfEvaluation(SelfEvaluation data) {
        mongoTemplate.save(data);
    }

    //更新
    public void updateMainInfo(MainInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().
                set("sno", data.getSno()).
                set("name", data.getName()).
                set("gender", data.getGender()).
                set("people", data.getPeople()).
                set("nativePlace", data.getNativePlace()).
                set("birthday", data.getBirthday()).
                set("major", data.getMajor()).
                set("health", data.getHealth()).
                set("phoneNumber", data.getPhoneNumber()).
                set("wxNumber", data.getWxNumber()).
                set("avatar", data.getAvatar());
        mongoTemplate.updateMulti(query, update, MainInfo.class);
    }

    public void updateAwardInfo(AwardInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("awards", data.getAwards());
        mongoTemplate.updateMulti(query, update, AwardInfo.class);
    }

    public void updateSkillInfo(SkillInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("skills", data.getSkills());
        mongoTemplate.updateMulti(query, update, SkillInfo.class);
    }
    public void updateWorkExpInfo(WorkExpInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("workExps", data.getWorkExps());
        mongoTemplate.updateMulti(query, update, WorkExpInfo.class);
    }

    public void updateEduExpInfo(EduExpInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("eduExps", data.getEduExps());
        mongoTemplate.updateMulti(query, update, EduExpInfo.class);
    }
    public void updateCourseInfo(CourseInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("courses", data.getCourses());
        mongoTemplate.updateMulti(query, update, CourseInfo.class);
    }

    public void updateActivityInfo(ActivityInfo data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("activities", data.getActivities());
        mongoTemplate.updateMulti(query, update, ActivityInfo.class);
    }
    public void updateSelfEvaluation(SelfEvaluation data) {
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("selfEvaluation", data.getSelfEvaluation());
        mongoTemplate.updateMulti(query, update, SelfEvaluation.class);
    }

//删除
    public void deleteMainInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, MainInfo.class);
    }
    public void deleteAwardInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, AwardInfo.class);
    }
    public void deleteSkillInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, SkillInfo.class);
    }
    public void deleteWorkExpInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, WorkExpInfo.class);
    }
    public void deleteEduExpInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, EduExpInfo.class);
    }
    public void deleteCourseInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, CourseInfo.class);
    }
    public void deleteActivityInfo(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, ActivityInfo.class);
    }
    public void deleteSelfEvaluation(String id) {
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query,SelfEvaluation.class);
    }


    //查询所有(生成名片信息)
    public List<SelfEvaluation> findAll() {
        return mongoTemplate.findAll(SelfEvaluation.class);

    }

//    搜索
    public List<MainInfo> searchSeeker(String words){
        Query query = new Query();
        Pattern pattern= Pattern.compile("^.*"+words+".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("name").regex(pattern), //姓名模糊查询
                Criteria.where("gender").regex(pattern),//性别查询
                Criteria.where("major").regex(pattern),   //专业模糊查询
                Criteria.where("sno").regex(pattern)//学号模糊查询

        );
        query.addCriteria(criteria);
        return mongoTemplate.find(query, MainInfo.class);
    }
}
