package com.geek.dao;

import com.geek.pojo.Contract;

public interface ContractDao {

    /**
     * 根据empid查合同
     * @param empId
     * @return
     */
    public Contract findByEmpId(int empId);
}
