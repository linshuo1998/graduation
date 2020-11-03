package com.linshuo.graduation.controller;


import com.linshuo.graduation.service.GetOpenIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GetUnionIdController {

    @GetMapping("/getOpenId")
    public String getOpenId(String code){
        GetOpenIdService getopenid=new GetOpenIdService();
        return getopenid.getopenid("wx6900a736b6ae0638",code,"34a348f3168858a7833c8e0f0a5ea25b");
    }

}
