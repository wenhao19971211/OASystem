package com.geek.dao;

import com.geek.pojo.WorkOn;
import org.apache.ibatis.annotations.Param;

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

}
