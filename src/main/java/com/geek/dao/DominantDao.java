package com.geek.dao;

import com.geek.pojo.Dominant;
import org.apache.ibatis.annotations.Param;

/**
 *员工可支配时间dao
 */
public interface DominantDao {
    /**
     * 根据员工编号查询可调休的时间
     * @param empId
     * @return
     */
    public Dominant findDominantByEmpId(int empId);

    /**
     * 根据员工的id修改年假时长
     * @param empId
     * @param yaerLeaveSumTime
     */
    public void updateYaerLeaveSumTimeByEmpId(@Param("id") int empId, @Param("sum")int yaerLeaveSumTime);

    /**
     * 根据员工编号修改员工的剩余年假时长
     * @param empId
     * @param reYearLeaveTime
     */
    public void updateReYearLeaveTimeByEmpId(@Param("id")int empId,@Param("sum")int reYearLeaveTime);

    /**
     * 根据员工编号修改可调休时长
     * @param empId
     * @param allowLeaveTime
     */
    public void updateAllowLeaveTimeByEmpId(@Param("id")int empId,@Param("sum")int allowLeaveTime);

    /**
     * 根据员工编号修改可补卡次数
     * @param empId
     * @param reCollectionCount
     */
    public void updateReCollectionCountByEmpId(@Param("id")int empId,@Param("sum")int reCollectionCount);

}
