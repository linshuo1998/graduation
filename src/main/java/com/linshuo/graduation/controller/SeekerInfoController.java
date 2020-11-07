package com.linshuo.graduation.controller;

import com.linshuo.graduation.entity.*;
import com.linshuo.graduation.service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
