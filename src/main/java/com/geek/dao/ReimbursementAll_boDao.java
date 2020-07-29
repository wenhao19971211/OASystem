package com.geek.dao;

import com.geek.bo.ReimbursementAll_bo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 报销表
 */
public interface ReimbursementAll_boDao {

    @Transactional
    public List<ReimbursementAll_bo> findAllReimbursement(@Param("checkStatus") int checkStatus);

}
