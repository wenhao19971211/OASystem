package com.geek.service;

import com.geek.dao.EmpDao;
import com.geek.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    EmpDao empDao;
    /**
     * 根据部门id查询部门经理
     * @return
     */
    public Emp findManagerBydepId(int depId){
        return empDao.findManagerBydepId(depId);
    }

}
