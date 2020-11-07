package com.linshuo.graduation.controller;

import com.linshuo.graduation.dao.RecruimentDao;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;
//  添加对象
    @PostMapping("/saveData")
    public void saveData(@RequestBody Recruitment recruitment){
//        System.out.println("asdadqw1232321::::::::::"+recruitment.getPoint().getName().toString());
        recruitmentService.addData(recruitment);
    }
//    查询所有
    @GetMapping("/findAll")
    public List<Recruitment> findAll(){
        return recruitmentService.findAll();
    }
//    根据标题模糊查询
    @GetMapping("/findByTitle")
    public List<Recruitment> findByTitle(@RequestParam(value = "title") String title){
        return recruitmentService.findByTitle(title);
    }
//    更新对象
    @PostMapping("/updateData")
    public void updateData(@RequestBody Recruitment recruitment){
        recruitmentService.updateData(recruitment);
    }
//    删除对象
    @GetMapping("/deleteData")
    public void deleteData(@RequestParam(value = "id") String id){
        recruitmentService.deleteData(id);
        System.out.println("删除成功");
    }

}
