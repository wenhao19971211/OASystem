package com.geek.service;

import com.geek.dao.CheckWorkDao;
import com.geek.pojo.CheckWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckWorkService {
    @Autowired
    private CheckWorkDao checkWorkDao;

    public List<CheckWork> findById(int empId){
        return checkWorkDao.findById(empId);
    }
}
