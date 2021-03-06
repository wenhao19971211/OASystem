package com.geek.dao;

import com.geek.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Emp> findAllEmp();

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

    /**
     * 修改个人信息
     * @param empId
     * @param head
     * @param phone
     * @param email
     */
    public void updateEmpById(@Param("empId") int empId,@Param("head")String head,@Param("phone")String phone,@Param("email")String email);

    /**
     * 根据部门编号查询经理
     * @param depId
     * @return
     */
    public Emp findManagerBydepId(int depId);

    /**
     * 查询所有信息
     * @param start
     * @param end
     * @return
     */
    public List<Emp> findAll(@Param("start")int start,@Param("end")int end);

    /**
     * 查询总数
     * @return
     */
    public int findCount();

    public List<Emp> findDeparture(@Param("start")int start,@Param("end")int end);

    /**
     * 修改离职状态
     * @param empId
     */
    public void updateDeparture(int empId);

    /**
     * 根据depId查询部门的所有员工
     * @param empId
     * @return
     */
    public List<Emp> findOneDepAllEmpsByEmpId(@Param("empId") Integer empId);

}
