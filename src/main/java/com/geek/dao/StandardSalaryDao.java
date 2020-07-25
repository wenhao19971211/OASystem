package com.geek.dao;

import com.geek.pojo.StandardSalary;

import java.util.List;

public interface StandardSalaryDao {

    /**
     * 查询所有员工的薪资标准
     * @return
     */
    public List<StandardSalary> findAllStandardSalary();



}
