package com.geek.dao;

import com.geek.pojo.Leave;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 事假dao
 */
public interface LeaveDao {

    /**
     * 根据empId和时间段查询该时间段内该员工的所有事假信息
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<Leave> findLeavesByEmpIdAndStartAndEnd(@Param("empId") Integer empId, @Param("start") Date start, @Param("end") Date end);



}
