package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.*;
import com.linshuo.graduation.service.RecruitmentService;
import com.linshuo.graduation.service.SeekerCardService;
import com.linshuo.graduation.service.SeekerInfoService;
import net.minidev.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BrowsingHistoryDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private SeekerCardService seekerCardService;

    //    保存对象
    public void saveData(BrowsingHistory data){
        mongoTemplate.save(data);
    }
    //    根据openid查询对象
    public Map<String,Object> findById(String openId, String type){
        Query query = new Query(Criteria.where("openId").is(openId).and("type").is(type));
        Sort sort = Sort.by(Sort.Direction.DESC,"lastVisitTime");
        query.with(sort);
        List<BrowsingHistory> browsingHistories = mongoTemplate.find(query,BrowsingHistory.class);
//        for(int x=0;x<browsingHistories.size();x++){
//        System.out.println(browsingHistories.get(x).getTarId());}
        Map<String,Object> results =new HashMap<String, Object>();

        if(type.equals("SeekerInfo")){
//            for(int i=0;i<browsingHistories.size();i++){
//                String tarId = browsingHistories.get(i).getTarId();
//                Map<String,Object> result =new HashMap<String, Object>();
//                Map<String,Object> result_ = new HashMap<String, Object>();
//                MainInfo mainInfo = seekerInfoService.findMainInfo(tarId);
//                WorkExpInfo workExpInfo = seekerInfoService.findWorkExpInfo(tarId);
//                String selfEvaluation = seekerInfoService.findSelfEvaluation(tarId).getSelfEvaluation();
//                String openId_ = mainInfo.getOpenId();
//                result_.put("id",openId_);
//                result_.put("MainInfo",mainInfo);
//                result_.put("WorkExpInfo",workExpInfo.getWorkExps());
//                result_.put("SelfEvaluation",selfEvaluation);
//
//                result.put("result",result_);
//                result.put("visitNum",browsingHistories.get(i).getVisitNum());
//                result.put("lastVisitTime",browsingHistories.get(i).getLastVisitTime());
//
//                String index = String.valueOf(i);
//                results.put(index,result);

//            }
            for(int i=0;i<browsingHistories.size();i++){
                String tarId = browsingHistories.get(i).getTarId();
                SeekerInfo seekerInfo = seekerCardService.findById(tarId);
                Map<String,Object> result =new HashMap<String, Object>();
                result.put("SeekerInfo",seekerInfo);
                result.put("visitNum",browsingHistories.get(i).getVisitNum());
                result.put("lastVisitTime",browsingHistories.get(i).getLastVisitTime());

                String index = String.valueOf(i);
                results.put(index,result);
            }
        }
        else if(type.equals("Recruitment")){
            for(int i=0;i<browsingHistories.size();i++){
                String tarId = browsingHistories.get(i).getTarId();
                Recruitment recruitment = recruitmentService.findById_(tarId);
                Map<String,Object> result =new HashMap<String, Object>();
                result.put("Recruitment",recruitment);
                result.put("visitNum",browsingHistories.get(i).getVisitNum());
                result.put("lastVisitTime",browsingHistories.get(i).getLastVisitTime());

                String index = String.valueOf(i);
                results.put(index,result);
            }
        }
//        System.out.println(results.toString());
        return results;
    }
    //    判断是否为空,返回浏览次数
    public Integer checkSaveOrUpdate(String openId, String id){
        Query query = new Query(Criteria.where("openId").is(openId).and("tarId").is(id));
        BrowsingHistory browsingHistory = mongoTemplate.findOne(query,BrowsingHistory.class);
        if(browsingHistory!=null){
            return browsingHistory.getVisitNum();
        }
        else{
            return 0;
        }
    }

    //   更新对象
    public void updateData(BrowsingHistory data){
        Query query = new Query(Criteria.where("openId").is(data.getOpenId()).and("tarId").is(data.getTarId()));
        Update update = new Update().
                set("lastVisitTime",data.getLastVisitTime()).set("visitNum",data.getVisitNum());
        mongoTemplate.updateMulti(query, update, BrowsingHistory.class);
    }

    //   删除对象
    public void deleteData(String openId, String id){
        Query query = new Query(Criteria.where("openId").is(openId).and("tarId").is(id));
        mongoTemplate.remove(query, BrowsingHistory.class);
    }
}
