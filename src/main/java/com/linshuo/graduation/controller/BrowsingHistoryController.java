package com.linshuo.graduation.controller;

import com.linshuo.graduation.entity.BrowsingHistory;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class BrowsingHistoryController {
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
//    添加对象
    @PostMapping("/saveBrowsingHistory")
    public void saveBrowsingHistory(@RequestBody BrowsingHistory data){
        browsingHistoryService.saveData(data);
    }
//    查询对象
    @GetMapping("/findBrowsingHistoryById")
    public Map<String, Object> findBrowsingHistoryById(@RequestParam(value = "openId") String openId,
                                                       @RequestParam(value = "type") String type){
        return browsingHistoryService.findById(openId,type);
    }

    @GetMapping("/checkSaveOrUpdate")
    public Integer checkSaveOrUpdate(@RequestParam(value = "openId") String openId,
                                     @RequestParam(value = "tarId") String id){
        return browsingHistoryService.checkSaveOrUpdate(openId,id);
    }
//    更新对象
    @PostMapping("/updateBrowsingHistory")
    public void updateBrowsingHistory(@RequestBody BrowsingHistory data){
        browsingHistoryService.updateData(data);
    }

//    删除对象
    @GetMapping("/deleteBrowsingHistory")
    public void deleteBrowsingHistory(@RequestParam(value = "openId") String openId,
                                      @RequestParam(value = "tarId") String id){
        browsingHistoryService.deleteData(openId,id);
    }
}
