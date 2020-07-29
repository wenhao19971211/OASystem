package com.geek.dao;

import com.geek.pojo.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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

    /**
     * 查询所有人事合同
     * @return
     */
    public List<Contract> findAll(@Param("start") int start,@Param("end") int end);

    /**
     * 查询合同总数
     * @return
     */
    public int findCount();

    /**
     * 修改合同
     * @param empId
     */
    public void updateById(@Param("empId") int empId, @Param("salary") double salary, @Param("effectTime")Date effectTime,@Param("failureTime") Date failureTime,@Param("contractType") int contractType);

}
