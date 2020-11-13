package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.MainInfo;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.entity.SeekerInfo;
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
    //   更新对象
    public void updateData(SeekerInfo data){
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()));
        Update update = new Update().set("mainInfo",data.getMainInfo()).
                set("selfEvaluation",data.getSelfEvaluation()).
                set("workExps",data.getWorkExps());
        mongoTemplate.updateMulti(query, update, SeekerInfo.class);
    }
    //    查询所有
    public List<SeekerInfo> findAll(){
        return mongoTemplate.findAll(SeekerInfo.class);
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
                Criteria.where("mainInfo.name").regex(pattern), //姓名模糊查询
                Criteria.where("mainInfo.gender").regex(pattern),//性别查询
                Criteria.where("mainInfo.major").regex(pattern),   //专业模糊查询
                Criteria.where("mainInfo.sno").regex(pattern)//学号模糊查询

        );
        query.addCriteria(criteria);
        return mongoTemplate.find(query, SeekerInfo.class);
    }



}
