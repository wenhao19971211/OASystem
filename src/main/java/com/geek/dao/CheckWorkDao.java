package com.geek.dao;

import com.geek.pojo.CheckWork;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface CheckWorkDao {
    /**
     * 查询考勤记录
     * @param empId
     * @return
     */
    public List<CheckWork> findById(@Param("empId") int empId, @Param("start")Date start,@Param("end") Date end);
}
