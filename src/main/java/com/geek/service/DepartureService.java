package com.geek.service;

import com.geek.dao.DepartureDao;
import com.geek.dao.EmpDao;
import com.geek.dao.MessageDao;
import com.geek.pojo.Departure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService {
    @Autowired
    private DepartureDao departureDao;
    @Autowired
    private EmpDao empDao;
    @Autowired
    private MessageDao messageDao;
    /**
     * 添加离职信息
     * @param departure
     */
    public void addDeparture(Departure departure){
        departureDao.addDeparture(departure);
    }

    /**
     * 查询离职信息
     * @return
     */
    public List<Departure> findDeparture(int checkEmpId,int start,int end){

        return departureDao.findDeparture(checkEmpId,start,end);
    }

    /**
     * 查询数量
     * @return
     */
    public int findCount(){
        return departureDao.findCount();
    }

    /**
     * 同意离职
     * @param empId
     */
    public void updateDeparture(int empId){
        empDao.updateDeparture(empId);
        departureDao.updateDepartureById(empId);
    }

    /**
     * 查询已经离职的信息
     * @param start
     * @param end
     * @return
     */
    public List<Departure> findDepartures(int start,int end){

        return departureDao.findDepartures(start,end);
    }

    /**
     * 删除离职信息
     * @param empId
     */
    public void delDepartureById(int empId){
        departureDao.delDepartureById(empId);
        System.out.println("删除成功");
    }
}
