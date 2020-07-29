package com.geek.dao;

import com.geek.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 薪资表
 */
public interface SalaryDao {

    /**
     * 添加薪资数据
     * @param salary
     * @return
     */
    public int addSalaryByEmpIdAndMonth(Salary salary);

    /**
     * 根据月份和empId查询薪资表
     * @param empId
     * @param month
     * @return
     */
    public Salary findSalaryByEmpIdAndMonth(@Param("empId") Integer empId, @Param("month") Date month);

    /**
     * 根据员工id查询所有薪资
     * @param empId
     * @param index
     * @param pageSize
     * @return
     */
    public List<Salary> findSalaryByEmpId(@Param("empId") Integer empId, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    /**
     * 根据salaryId查询薪资表
     * @param slaryId
     * @return
     */
    public Salary findSalaryBySalaryId(@Param("salaryId") Integer slaryId);

}
