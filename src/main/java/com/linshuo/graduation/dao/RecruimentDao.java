package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.*;
import com.mongodb.client.MongoCursor;
import org.elasticsearch.search.suggest.SortBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class RecruimentDao<Recruiment> {
    @Autowired
    private MongoTemplate mongoTemplate;

//    保存对象
public void saveData(Recruitment data){
    mongoTemplate.save(data);
}


    //    查询所有
    public List<Recruitment> findAll(){
        Query query = new Query();
        Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
        query.with(sort);

        return mongoTemplate.find(query,Recruitment.class);
//        后期可以在saveData里加索引优化查询

    }
//    根据openid查询对象
    public Recruitment findById(String id,String id_){
        Query query = new Query(Criteria.where("userOpenId").is(id).and("id").is(id_));
        return mongoTemplate.findOne(query,Recruitment.class);
}
    //    根据id查询对象
    public Recruitment findById_(String id){
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,Recruitment.class);
    }
//    根据标题查询对象
    public List<Recruitment> findByTitle(String title){
//        System.out.println("参数是"+title);

//        Query query = new Query(Criteria.where("title").is(title));

//          实现模糊查询
        Query query = new Query();
        Pattern pattern= Pattern.compile("^.*"+title+".*$", Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("title").regex(pattern));

        List<Recruitment> list = mongoTemplate.find(query,Recruitment.class);
        for(int i = 0; i < list.size(); i++)
        {
            Recruitment r = (Recruitment) list.get(i);
            System.out.println(r.getId()+"  "+r.getTitle()+"  ");

        }
        return mongoTemplate.find(query, Recruitment.class);
    }

//   更新对象
    public void updateData(Recruitment data){
        Query query = new Query(Criteria.where("id").is(data.getId()));
        Update update = new Update().set("title",data.getTitle()).
                set("wage",data.getWage()).set("tags",data.getTags()).set("avatar",data.getAvatar()).
                set("name",data.getName()).set("time",data.getTime()).set("workDetail",data.getWorkDetail()).
                set("need",data.getNeed()).set("phoneNumber",data.getPhoneNumber()).set("wxNumber",data.getWxNumber()).
                set("point",data.getPoint()).set("address",data.getAddress()).set("addressDetail",data.getAddressDetail()).
                set("userOpenId",data.getUserOpenId()).set("publishTime",data.getPublishTime());
        mongoTemplate.updateMulti(query, update, Recruitment.class);
    }

//    删除对象
    public void deleteData(String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Recruitment.class);
    }



//    查询已发布
    public List<Recruitment> findPublished(String id){
    Query query = new Query(Criteria.where("userOpenId").is(id));
    Sort sort = Sort.by(Sort.Direction.DESC,"publishTime");
    query.with(sort);
    return mongoTemplate.find(query, Recruitment.class);
    }
//    搜索
    public List<Recruitment> searchRecruitment(String words){
        Query query = new Query();
        Pattern pattern= Pattern.compile("^.*"+words+".*$", Pattern.CASE_INSENSITIVE);
        Criteria criteria = new Criteria();
        criteria.orOperator(
                Criteria.where("title").regex(pattern), //标题模糊查询
                Criteria.where("address").regex(pattern),//地点模糊查询
                Criteria.where("tags").regex(pattern),   //标签匹配
                Criteria.where("addressDetail").regex(pattern),//详情地址查询
                Criteria.where("wage").regex((pattern)) //薪酬模糊查询
                );
        query.addCriteria(criteria);
        return mongoTemplate.find(query, Recruitment.class);

    }
}
