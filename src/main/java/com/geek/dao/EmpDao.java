package com.geek.dao;

import com.geek.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpDao {
    /**
     * 根据用户名查询
     * @param account
     * @return
     */
    public Emp findEmpByAccount(String account);

    /**
     * 根据empId查询
     * @param empId
     * @return
     */
    public Emp findEmpById(int empId);

    public void updateEmpById(@Param("empId") int empId,@Param("head")String head,@Param("phone")String phone,@Param("email")String email);
}
