package com.linshuo.graduation.service.impl;

import com.linshuo.graduation.dao.BrowsingHistoryDao;
import com.linshuo.graduation.dao.RecruimentDao;
import com.linshuo.graduation.entity.BrowsingHistory;
import com.linshuo.graduation.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Autowired
    private BrowsingHistoryDao browsingHistoryDao;

    @Override
    public Map<String, Object> findById(String openId, String type) {
        return browsingHistoryDao.findById(openId,type);
    }

    @Override
    public Integer checkSaveOrUpdate(String openId, String id) {
        return browsingHistoryDao.checkSaveOrUpdate(openId, id);
    }

    @Override
    public void saveData(BrowsingHistory data) {
        browsingHistoryDao.saveData(data);
    }

    @Override
    public void updateData(BrowsingHistory data) {
        browsingHistoryDao.updateData(data);
    }

    @Override
    public void deleteData(String openId, String id) {
        browsingHistoryDao.deleteData(openId,id);
    }
}
