package com.geek.dao;

import com.geek.pojo.SalaryIssue;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 薪酬发放表dao
 */
public interface SalaryIssueDao {

    /**
     * 添加
     * @param salaryIssue
     * @return
     */
    public int addSalaryIssue(SalaryIssue salaryIssue);

    /**
     * 根据状态查询薪资发发数据
     * @param status
     * @param index
     * @param pageSize
     * @return
     */
    public List<SalaryIssue> findSalaryIssueByStatus(@Param("status") Integer status, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    /**
     * 根据id更新发放状态
     * @param id
     * @param status
     * @return
     */
    public int updateSalaryIssueStatusBySalaryIssueId(@Param("id") Integer id, @Param("status") Integer status, @Param("issueTime") Date issueTime);

}
