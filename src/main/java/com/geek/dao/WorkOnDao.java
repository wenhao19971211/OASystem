package com.geek.dao;

import com.geek.pojo.WorkOn;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * 打卡dao
 */
public interface WorkOnDao {


    /**
     * 根据empid和月份时间段查询该月份的所有打卡记录
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<WorkOn> findWorkOnsByEmpIdAndMonth(@Param("empId") Integer empId,@Param("start") Date start,@Param("end") Date end);


    /**
     * 上班考勤打卡记录写入
     * @param empId id
     * @param today 今天的时间
     * @param workInTime 打卡时间
     * @return
     */
    public void insertWorkOnByEmpId(@Param("empId") int empId, @Param("today") Date today, @Param("workInTime") Date workInTime);


    /**
     * 下班打卡记录表
     * @param empId id
     * @param workOutTime 下半1打卡时间
     */
    public void updateWorkOnByEmpId(@Param("empId") int empId,  @Param("workOutTime") Date workOutTime);

}
