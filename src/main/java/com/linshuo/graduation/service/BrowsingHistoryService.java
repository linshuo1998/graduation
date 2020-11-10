package com.linshuo.graduation.service;

import com.linshuo.graduation.entity.BrowsingHistory;
import com.linshuo.graduation.entity.Recruitment;

import java.util.List;
import java.util.Map;

public interface BrowsingHistoryService {
    //    查询对象
    public Map<String,Object> findById(String openId, String type);
    public Integer checkSaveOrUpdate(String openId,String id);
    //    添加对象
    public void saveData(BrowsingHistory data);
    //    更新对象
    public void updateData(BrowsingHistory data);
    //    删除对象
    public void deleteData(String openId,String id);


}
