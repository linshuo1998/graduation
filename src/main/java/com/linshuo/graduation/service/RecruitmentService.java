package com.linshuo.graduation.service;

import com.linshuo.graduation.entity.Recruitment;

import java.util.List;

public interface RecruitmentService {
//    查询所有
    public List<Recruitment> findAll();
//    添加对象
    public void addData(Recruitment r);
//    删除对象
    public void deleteData(String id);
//    修改对象
    public void updateData(Recruitment r);
//    查询对象
    public Recruitment findByTitle(String t);
}
