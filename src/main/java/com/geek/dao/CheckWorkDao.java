package com.geek.dao;

import com.geek.pojo.CheckWork;

import java.util.List;

public interface CheckWorkDao {
    /**
     * 查询考勤记录
     * @param empId
     * @return
     */
    public List<CheckWork> findById(int empId);
}
