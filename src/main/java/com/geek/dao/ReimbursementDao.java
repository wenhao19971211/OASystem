package com.geek.dao;

import com.geek.bo.ReimbursementAll_bo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 报销表
 */
public interface ReimbursementDao {
    //发送员工申请报销
    /**
     * 申请报销
     * @param reimbursementId 报销表的编号
     * @param empId 报销人的id
     * @param taskSendId 相关任务的Id
     * @param date 报销的时间
     * @param sum 报销的总金额
     */
    @Transactional
    public void insertReimbursement(@Param("reimbursementId") Integer reimbursementId, @Param("empId") int empId, @Param("taskSendId") int taskSendId, @Param("sendTime") Date date,@Param("sum") double sum,@Param("date") Date dates,@Param("type") int type);


    @Transactional
    public void updateSomeStatues(@Param("statue") int statue,@Param("reimbursementId") Integer reimbursementId);
}
