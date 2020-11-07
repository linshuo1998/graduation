package com.linshuo.graduation.service.impl;

import com.linshuo.graduation.dao.RecruimentDao;
import com.linshuo.graduation.entity.Recruitment;
import com.linshuo.graduation.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruimentDao recruimentDao;

    @Override
    public List<Recruitment> findAll() {
        return recruimentDao.findAll();
    }

    @Override
    public void addData(Recruitment r) {
        recruimentDao.saveData(r);
    }

    @Override
    public void deleteData(String id) {
        recruimentDao.deleteData(id);
    }

    @Override
    public void updateData(Recruitment r) {
        recruimentDao.updateData(r);
    }

    @Override
    public List<Recruitment> findByTitle(String t) {
        return recruimentDao.findByTitle(t);
    }
}
