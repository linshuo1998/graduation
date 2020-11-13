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

    @PostMapping("/saveCard")
    public void saveCard(@RequestBody SeekerInfo data){
        seekerCardService.addData(data);
    }

    @PostMapping("/updateCard")
    public void update(@RequestBody SeekerInfo data){
        seekerCardService.updateData(data);
    }

    @GetMapping("/findAllSeekerCard")
    public List<SeekerInfo> findAllSeekerCard(){
        return seekerCardService.findAll();
    }
    @GetMapping("findSeekerCardById")
    public SeekerInfo findSeekerCardById(@RequestParam(value = "id")String id){
        return seekerCardService.findById(id);
    }
}
