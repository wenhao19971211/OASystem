package com.geek.dao;

import com.geek.pojo.Contract;
import org.apache.ibatis.annotations.Param;

/**
 * 人事合同dao
 */
public interface ContractDao {

    /**
     * 根据empId查询人事合同
     * @param empId
     * @return
     */
    public Contract findContractByEmpId(@Param("empId") Integer empId);

}
