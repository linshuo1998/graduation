package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.MainInfo;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.entity.SeekerInfo;
import com.linshuo.graduation.entity.SelfEvaluation;
import org.elasticsearch.common.recycler.Recycler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import sun.misc.Cache;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class SeekerCardDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //    保存对象
    public void saveData(SeekerInfo data){
        mongoTemplate.save(data);
    }
    //    删除
    public void deleteData(String id){
        Query query = new Query(Criteria.where("openId").is(id));
        mongoTemplate.remove(query, SeekerInfo.class);
    }
    //   更新对象
    public void updateData(SeekerInfo data){
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().
                set("name",data.getName()).set("sno",data.getSno()).set("gender",data.getGender()).
                set("major",data.getMajor()).set("wxNumber",data.getWxNumber()).set("phoneNumber",data.getPhoneNumber()).
                set("avatar",data.getAvatar()).set("selfEvaluation",data.getSelfEvaluation()).
                set("workExps",data.getWorkExps()).set("publishTime",data.getPublishTime()).
                set("publishable",data.getPublishable());
        mongoTemplate.updateMulti(query, update, SeekerInfo.class);
    }
    //    查询所有
    public List<SeekerInfo> findAll(){
        Query query = new Query(Criteria.where("publishable").is(true));
        Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
        query.with(sort);
        return mongoTemplate.find(query, SeekerInfo.class);
    }
    public List<SeekerInfo> admin_findAll(){
        Query query = new Query(Criteria.where("publishable").is(false));
        Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
        query.with(sort);
        return mongoTemplate.find(query, SeekerInfo.class);
    }
    //    查询
    public SeekerInfo findById(String id){
        Query query = new Query();
        query.addCriteria(Criteria.where("openId").is(id));
        return mongoTemplate.findOne(query,SeekerInfo.class);
    }
    //    搜索
    public List<SeekerInfo> searchSeeker(String words){
        Query query = new Query();
        Pattern pattern= Pattern.compile("^.*"+words+".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("name").regex(pattern), //姓名模糊查询
                Criteria.where("gender").regex(pattern),//性别查询
                Criteria.where("major").regex(pattern),   //专业模糊查询
                Criteria.where("sno").regex(pattern),//学号模糊查询
                Criteria.where("phoneNumber").regex(pattern),  //手机号码查询
                Criteria.where("wxNumber").regex(pattern)   //微信号查询

        );
        criteria.andOperator(Criteria.where("publishable").is(true));
        query.addCriteria(criteria);
        Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
        query.with(sort);
        return mongoTemplate.find(query, SeekerInfo.class);
    }

    public List<SeekerInfo> admin_searchSeeker(String words){
        Query query = new Query();
        Pattern pattern= Pattern.compile("^.*"+words+".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("name").regex(pattern), //姓名模糊查询
                Criteria.where("gender").regex(pattern),//性别查询
                Criteria.where("major").regex(pattern),   //专业模糊查询
                Criteria.where("sno").regex(pattern),//学号模糊查询
                Criteria.where("phoneNumber").regex(pattern),  //手机号码查询
                Criteria.where("wxNumber").regex(pattern)   //微信号查询

        );
        criteria.andOperator(Criteria.where("publishable").is(false));
        query.addCriteria(criteria);
        Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
        query.with(sort);
        return mongoTemplate.find(query, SeekerInfo.class);
    }

}
