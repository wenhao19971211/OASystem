package com.geek.dao;

import com.geek.pojo.Leave;
import com.geek.pojo.YearLeave;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 年假dao
 */
public interface YearLeaveDao {


    /**
     * 根据empId和时间段查询该时间段内该员工的所有年假信息
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<YearLeave> findYearLeavesByEmpIdAndStartAndEnd(@Param("empId") Integer empId, @Param("start") Date start, @Param("end") Date end);


}
