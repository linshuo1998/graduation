package com.linshuo.graduation.controller;

import com.linshuo.graduation.entity.SeekerInfo;
import com.linshuo.graduation.service.SeekerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeekerCardController {
    @Autowired
   private SeekerCardService seekerCardService;

    @GetMapping("/searchSeeker")
    public List<SeekerInfo> searchSeeker(@RequestParam(value = "words")String words){
        return seekerCardService.searchSeeker(words);
    }
    @GetMapping("/admin_searchSeeker")
    public List<SeekerInfo> admin_searchSeeker(@RequestParam(value = "words")String words){
        return seekerCardService.admin_searchSeeker(words);
    }


    @PostMapping("/saveCard")
    public void saveCard(@RequestBody SeekerInfo data){
        seekerCardService.addData(data);
    }

    @PostMapping("/updateCard")
    public void update(@RequestBody SeekerInfo data){
        seekerCardService.updateData(data);
    }

    @GetMapping("/admin_findAllSeekerCard")
    public List<SeekerInfo> admin_findAllSeekerCard(){
        return seekerCardService.admin_findAll();
    }
    @GetMapping("/findAllSeekerCard")
    public List<SeekerInfo> findAllSeekerCard(){
        return seekerCardService.findAll();
    }

    @GetMapping("findSeekerCardById")
    public SeekerInfo findSeekerCardById(@RequestParam(value = "id")String id){
        return seekerCardService.findById(id);
    }

    @GetMapping("/deleteSeekerCard")
    public void deleteSeekerCard(@RequestParam(value = "id") String id){
        seekerCardService.deleteData(id);
    }
}
