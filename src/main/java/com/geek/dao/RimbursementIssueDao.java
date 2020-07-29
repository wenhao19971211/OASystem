package com.geek.dao;

import com.geek.pojo.Reimbursement;
import com.geek.pojo.Rimbursement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报销发放
 */
public interface RimbursementIssueDao {

    /**
     * 根据状态查询报销发发数据
     * @param status
     * @param index
     * @param pageSize
     * @return
     */
    public List<Rimbursement> findRimbursementByStatus(@Param("status") Integer status, @Param("index") Integer index, @Param("pageSize") Integer pageSize);

    /**
     * 根据报销发放id更新发放状态
     * @param id
     * @param status
     * @return
     */
    public int updateRimbursementIssueStatusByRimbursementIsuueId(@Param("id") Integer id,@Param("status") Integer status);

    /**
     * 根据报销id，查询报销表
     * @param reimbursementId
     * @return
     */
    public Reimbursement findReimbursementByReimbursementId(@Param("reimbursementId") Integer reimbursementId);

    /**
     * 根据id
     * @param reimbursementId
     * @return
     */
    public int updateReimbursementStatus4ByReimbursementId(@Param("reimbursementId") Integer reimbursementId,@Param("status") Integer status);


}
