package com.geek.service;

import com.geek.dao.ContractDao;
import com.geek.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {
    @Autowired
    private ContractDao contractDao;

    /**
     * 查看个人合同
     * @param empId
     * @return
     */
    public Contract findContractByEmpId(int empId){
        return contractDao.findByEmpId(empId);
    }
}
