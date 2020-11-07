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
public class RecruimentDao {
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
        Update update = new Update().set("title",data.getTitle()).set("wageDetail",data.getWage());
//        返回第一条
//        return mongoTemplate.updateFirst(query,update,RecruitmentInfo.class);
//        返回所有
        mongoTemplate.updateMulti(query, update, Recruitment.class);
    }

//    删除对象
    public void deleteData(String id){
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Recruitment.class);
    }


}
