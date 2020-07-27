package com.geek.dao;

import com.geek.pojo.Salary;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

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

}
