package com.linshuo.graduation.service.impl;

import com.linshuo.graduation.dao.SeekerCardDao;
import com.linshuo.graduation.entity.SeekerInfo;
import com.linshuo.graduation.service.SeekerCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeekerCardServiceImpl implements SeekerCardService {
    @Autowired
    private SeekerCardDao seekerCardDao;
    @Override
    public List<SeekerInfo> findAll() {
        return seekerCardDao.findAll();
    }

    @Override
    public void addData(SeekerInfo r) {
        seekerCardDao.saveData(r);
    }

    @Override
    public void updateData(SeekerInfo r) {
        seekerCardDao.updateData(r);
    }

    @Override
    public SeekerInfo findById(String id) {
        return seekerCardDao.findById(id);
    }

    @Override
    public List<SeekerInfo> searchSeeker(String words) {
        return seekerCardDao.searchSeeker(words);
    }
}
