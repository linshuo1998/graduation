package com.linshuo.graduation.controller;

import com.linshuo.graduation.entity.MainInfo;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.entity.SelfEvaluation;
import com.linshuo.graduation.entity.WorkExpInfo;
import com.linshuo.graduation.service.GetOpenIdService;
import com.linshuo.graduation.service.RecruitmentService;
import com.linshuo.graduation.service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    private RecruitmentService recruitmentService;
    @Autowired
    private SeekerInfoService seekerInfoService;

    @GetMapping("/searchRecruitment")
    public List<Recruitment> searchRecruitment(@RequestParam(value = "words") String words) {
        return recruitmentService.searchRecruitment(words);

    }

    @GetMapping("/admin_searchRecruitment")
    public List<Recruitment> admin_searchRecruitment(@RequestParam(value = "words") String words) {
        return recruitmentService.admin_searchRecruitment(words);

    }


//    @GetMapping("/searchSeeker")
//    public Map<String, Object> searchSeeker(@RequestParam(value = "words") String words) {
//        Map<String, Object> results = new HashMap<String, Object>();
//        List<MainInfo> mainInfos = seekerInfoService.searchSeeker(words);
//
//        for (int i = 0; i < mainInfos.size(); i++) {
//            Map<String, Object> result = new HashMap<String, Object>();
//            String id = mainInfos.get(i).getOpenId();
//            SelfEvaluation selfEvaluation = seekerInfoService.findSelfEvaluation(id);
//            String _selfEvaluation = "";
//            if (selfEvaluation == null) {
//                continue;
//            }
//            else{
//                _selfEvaluation=selfEvaluation.getSelfEvaluation();
//                MainInfo mainInfo = mainInfos.get(i);
//                WorkExpInfo workExpInfo = seekerInfoService.findWorkExpInfo(id);
//                result.put("id", id);
//                result.put("MainInfo", mainInfo);
//                result.put("WorkExpInfo", workExpInfo);
//                result.put("SelfEvaluation", _selfEvaluation);
//
//                results.put(id, result);
//
//        }
//        }
//        System.out.println(results.toString());
//        return results;
//
//    }

}
