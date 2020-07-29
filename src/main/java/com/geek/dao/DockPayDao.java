package com.geek.dao;

import com.geek.pojo.DockPay;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 扣薪
 */
public interface DockPayDao {

    /**
     * 添加扣薪表
     * @param dockPay
     * @return
     */
    public int addDockPay(DockPay dockPay);


    /**
     * 根据empid和月份查询扣薪详情
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<DockPay> findDockPayByEmpIdAndStartAndEnd(@Param("empId") Integer empId,@Param("start") Date start,@Param("end") Date end);

}
