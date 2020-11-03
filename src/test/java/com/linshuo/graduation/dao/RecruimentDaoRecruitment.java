package com.linshuo.graduation.dao;

import com.linshuo.graduation.entity.Recruitment;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RecruimentDaoRecruitment {
    @Autowired
    private RecruimentDao recruimentDao;

    @org.junit.jupiter.api.Test
    void saveData() {
        Recruitment data = new Recruitment();
        data.setId("1w3231");
        data.setTitle("linshuo ");
        recruimentDao.saveData(data);
    }

    @org.junit.jupiter.api.Test
    List<Recruitment> findAll() {
        List<Recruitment> data = recruimentDao.findAll();
        return data;
    }

    @org.junit.jupiter.api.Test
    void findByTitle() {
        Recruitment data = (Recruitment) recruimentDao.findByTitle("shu");
        System.out.println("data is:"+data);
    }

    @org.junit.jupiter.api.Test
    void updateData() {
        Recruitment data = new Recruitment();
        data.setId("1w3231");
        data.setTitle("dsadsadsa");
        recruimentDao.updateData(data);
    }

    @org.junit.jupiter.api.Test
    void deleteData() {
        recruimentDao.deleteData("1w3231");
    }
}