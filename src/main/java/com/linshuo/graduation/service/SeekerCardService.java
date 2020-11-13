package com.linshuo.graduation.service;

import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.entity.SeekerInfo;

import java.util.List;

public interface SeekerCardService {
    //    查询所有
    public List<SeekerInfo> findAll();
    //    添加对象
    public void addData(SeekerInfo r);
    //    修改对象
    public void updateData(SeekerInfo r);
    //    查询对象
    public SeekerInfo findById(String id);
    //    搜索对象
    public List<SeekerInfo> searchSeeker(String words);

}
