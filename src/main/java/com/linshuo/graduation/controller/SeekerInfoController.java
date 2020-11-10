package com.linshuo.graduation.controller;

import com.linshuo.graduation.entity.*;
import com.linshuo.graduation.service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SeekerInfoController {
    @Autowired
    private SeekerInfoService seekerInfoService;
//MainInfo
    //    添加对象
    @PostMapping("/saveMainInfo")
    public void saveMainInfo(@RequestBody MainInfo data){
        seekerInfoService.addMainInfo(data);
    }
    //    查看对象
    @GetMapping("/findMainInfo")
    public MainInfo findMainInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findMainInfo(id);
    }
    //    更新对象
    @PostMapping("/updateMainInfo")
    public void updateMainInfo(@RequestBody MainInfo data){
        seekerInfoService.updateMainInfo(data);
    }


//AwardInfo
    //    添加对象
    @PostMapping("/saveAwardInfo")
    public void saveAwardInfo(@RequestBody AwardInfo data){
        seekerInfoService.addAwardInfo(data);
    }
    //    查看对象
    @GetMapping("/findAwardInfo")
    public AwardInfo findAwardInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findAwardInfo(id);
    }
    //    更新对象
    @PostMapping("/updateAwardInfo")
    public void updateAwardInfo(@RequestBody AwardInfo data){
        seekerInfoService.updateAwardInfo(data);
    }

//SkillInfo
    //    添加对象
    @PostMapping("/saveSkillInfo")
    public void saveSkillInfo(@RequestBody SkillInfo data){
    seekerInfoService.addSkillInfo(data);
}
    //    查看对象
    @GetMapping("/findSkillInfo")
    public SkillInfo findSkillInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findSkillInfo(id);
    }
    //    更新对象
    @PostMapping("/updateSkillInfo")
    public void updateSkillInfo(@RequestBody SkillInfo data){
        seekerInfoService.updateSkillInfo(data);
    }

//WorkExpInfo
//    添加对象
    @PostMapping("/saveWorkExpInfo")
    public void saveWorkExpInfo(@RequestBody WorkExpInfo data){
    seekerInfoService.addWorkExpInfo(data);
}
    //    查看对象
    @GetMapping("/findWorkExpInfo")
    public WorkExpInfo findWorkExpInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findWorkExpInfo(id);
    }
    //    更新对象
    @PostMapping("/updateWorkExpInfo")
    public void updateWorkExpInfo(@RequestBody WorkExpInfo data){
        seekerInfoService.updateWorkExpInfo(data);
    }

//EduExoInfo
    //    添加对象
    @PostMapping("/saveEduExpInfo")
    public void saveEduExpInfo(@RequestBody EduExpInfo data){
    seekerInfoService.addEduExpInfo(data);
}
    //    查看对象
    @GetMapping("/findEduExpInfo")
    public EduExpInfo findEduExpInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findEduExpInfo(id);
    }
    //    更新对象
    @PostMapping("/updateEduExpInfo")
    public void updateEduExpInfo(@RequestBody EduExpInfo data){
        seekerInfoService.updateEduExpInfo(data);
    }
//   Course
    //    添加对象
    @PostMapping("/saveCourseInfo")
    public void saveCourseInfo(@RequestBody CourseInfo data){
    seekerInfoService.addCourseInfo(data);
}
    //    查看对象
    @GetMapping("/findCourseInfo")
    public CourseInfo findCourseInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findCourseInfo(id);
    }
    //    更新对象
    @PostMapping("/updateCourseInfo")
    public void updateCourseInfo(@RequestBody CourseInfo data){
        seekerInfoService.updateCourseInfo(data);
    }


//    ActivityInfo
    //    添加对象
    @PostMapping("/saveActivityInfo")
    public void saveActivityInfo(@RequestBody ActivityInfo data){
    seekerInfoService.addActivityInfo(data);
}
    //    查看对象
    @GetMapping("/findActivityInfo")
    public ActivityInfo findActivityInfo(@RequestParam(value = "id") String id){
        return seekerInfoService.findActivityInfo(id);
    }
    //    更新对象
    @PostMapping("/updateActivityInfo")
    public void updateActivityInfo(@RequestBody ActivityInfo data){
        seekerInfoService.updateActivityInfo(data);
    }








//SelfEvaluation
    //    添加对象
    @PostMapping("/saveSelfEvaluation")
    public void saveWorkExpInfo(@RequestBody SelfEvaluation data){
        seekerInfoService.addSelfEvaluation(data);
    }
    //    查看对象
    @GetMapping("/findSelfEvaluation")
    public SelfEvaluation findSelfEvaluation(@RequestParam(value = "id") String id){
        return seekerInfoService.findSelfEvaluation(id);
    }
    //    更新对象
    @PostMapping("/updateSelfEvaluation")
    public void updateSelfEvaluation(@RequestBody SelfEvaluation data){
        seekerInfoService.updateSelfEvaluation(data);
    }



    //    查看所有自评表，根据openid获取基本信息及工作经历，并汇总成一个新json格式返回
    @GetMapping("/getAllSeekerInfo")
    public Map<String,Object> getAllSeekerInf(){
    Map<String,Object> results =new HashMap<String, Object>();
    List<SelfEvaluation> selfEvaluations = seekerInfoService.findAll();
    for(int i=0;i<selfEvaluations.size();i++){
        Map<String,Object> result =new HashMap<String, Object>();
        String id = selfEvaluations.get(i).getOpenId();
        MainInfo mainInfo = seekerInfoService.findMainInfo(id);
        WorkExpInfo workExpInfo = seekerInfoService.findWorkExpInfo(id);
        String selfEvaluation = selfEvaluations.get(i).getSelfEvaluation();
        result.put("id",id);
        result.put("MainInfo",mainInfo);
        result.put("WorkExpInfo",workExpInfo.getWorkExps());
        result.put("SelfEvaluation",selfEvaluation);

        results.put(id,result);
    }
        System.out.println(results.toString());
        return results;
    }
}
