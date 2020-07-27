package com.geek.dao;

import com.geek.pojo.DayOff;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 调休dao
 */
public interface DayOffDao {
    /**
     * 增加调休信息
     * @param applyEmpId 员工id
     * @param dayOffCause 原因
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param checkEmpId 审核人的id
     * @param checkTime 审核时间
     * @param checkStatus 审核的状态
     */
    public void addDayOff(@Param("id") int applyEmpId,
                          @Param("cause")String dayOffCause,
                          @Param("start")Date startTime,
                          @Param("end")Date endTime,
                          @Param("auditorId")int checkEmpId,
                          @Param("checkTime")Date checkTime,
                          @Param("state")int checkStatus);

    /**
     * 查看请假 只写dep代表经理查询审批,emp写0 员工反之
     * @return
     */
    public List<DayOff> findAllDayOffBydepIdAndempId(@Param("depId")int depId,@Param("empId")int empId,@Param("state") int state ,@Param("flag")int flag);

    /**
     * 修改审核时间
     * @param date
     * @param id
     */
    public void updateCheckTimeByDayOffId(@Param("date")Date date,@Param("id") int id);

    /**
     * 修改审核的状态
     * @param state
     * @param id
     */
    public void updatecheckStatusByDayOffId(@Param("state")int state,@Param("id") int id);

    /**
     * 根据empId和时间段查询该时间段内该员工的所有调休信息
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<DayOff> findDayOffsByEmpIdAndStartAndEnd(@Param("empId") Integer empId,@Param("start") Date start,@Param("end") Date end);




}
