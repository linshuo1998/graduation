package com.linshuo.graduation.service;

import com.linshuo.graduation.entity.Recruitment;

import java.util.List;

public interface RecruitmentService {
//    查询所有
    public List<Recruitment> findAll();
    public List<Recruitment> admin_findAll();
//    添加对象
    public void addData(Recruitment r);
//    删除对象
    public void deleteData(String id);
//    修改对象
    public void updateData(Recruitment r);
//    查询对象
    public Recruitment findById(String id,String id_);
    public List<Recruitment> findByTitle(String t);
    public Recruitment findById_(String id);


//    查询已发布信息
    public List<Recruitment> findPublished(String t);

//    搜索对象
    public List<Recruitment> searchRecruitment(String words);
    public List<Recruitment> admin_searchRecruitment(String words);
}
