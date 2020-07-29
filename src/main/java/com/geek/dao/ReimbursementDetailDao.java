package com.geek.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 报销明细表
 */
public interface ReimbursementDetailDao {
    /**
     * 添加报销信息
     * @param type 不同类型添加不同的报销信息
     * @param detail 报销的详细信息
     * @param money 报销的总金额
     * @Param ReimbursementId 报销的Id
     */
    public void insertDetailMessge(@Param("type") int type,@Param("detail") String detail,@Param("money") double money,@Param("ReimbursementId") int ReimbursementId);




}
