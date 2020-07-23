package com.geek.service;

import com.geek.dao.EmpDao;
import com.geek.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    /**
     * 根据用户名查询
     * @param account
     * @return
     */
    @Transactional
    public Emp findEmpByAccount(String account){
        return empDao.findEmpByAccount(account);
    }

    public Emp findEmpById(int empId){
        return empDao.findEmpById(empId);
    }

    public void updateInformation(int empId,String head,String phone,String email){
        empDao.updateEmpById(empId,head,phone,email);
    }
}
