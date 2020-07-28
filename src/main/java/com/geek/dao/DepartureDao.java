package com.geek.dao;

import com.geek.pojo.Departure;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface DepartureDao {
    /**
     * 添加离职
     * @param departure
     */
    public void addDeparture(Departure departure);

    /**
     * 根据审核人查询离职信息
     * @param
     * @return
     */
    public List<Departure> findDeparture(@Param("start") int start,@Param("end") int end);

    public int findCount();

    /**
     * 修改离职信息
     * @param empId
     */
    public void updateDepartureById(int empId);

    /**
     * 查询已经离职信息
     * @param start
     * @param end
     * @return
     */
    public List<Departure> findDepartures(@Param("start") int start,@Param("end") int end);
}
