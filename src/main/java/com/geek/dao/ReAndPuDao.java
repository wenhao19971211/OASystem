package com.geek.dao;

import com.geek.pojo.ReAndPu;

import java.util.List;

public interface ReAndPuDao {
    /**
     * 根据Id查询奖惩记录
     * @param empId
     * @return
     */
    public List<ReAndPu> findById(int empId);
}
