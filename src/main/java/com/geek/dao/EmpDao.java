package com.geek.dao;

import com.geek.pojo.Emp;

public interface EmpDao {


    /**
     * 根据部门编号查询经理
     * @param depId
     * @return
     */
    public Emp findManagerBydepId(int depId);

}
