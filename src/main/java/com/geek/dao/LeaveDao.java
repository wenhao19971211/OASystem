package com.geek.dao;

import com.geek.pojo.DayOff;
import com.geek.pojo.Leave;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 事假dao
 */
public interface LeaveDao {
    /**
     * 增加事假信息
     * @param applyEmpId 员工id
     * @param leaveCause 原因
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param checkEmpId 审核人的id
     * @param checkTime 审核时间
     * @param checkStatus 审核的状态
     */
    public void addLeave(@Param("id") int applyEmpId,
                          @Param("cause")String leaveCause,
                          @Param("start") Date startTime,
                          @Param("end")Date endTime,
                          @Param("auditorId")int checkEmpId,
                          @Param("checkTime")Date checkTime,
                          @Param("state")int checkStatus);
    /**
     * 查看所有的事假申请
     * @return
     */
    public List<Leave> findAllLeave();


    /**
     * 修改审核时间
     * @param date
     * @param id
     */
    public void updateCheckTimeByleaveId(@Param("date")Date date,@Param("id") int id);

    /**
     * 修改审核的状态
     * @param state
     * @param id
     */
    public void updateCheckStatusByleaveId(@Param("state")int state,@Param("id") int id);
}
