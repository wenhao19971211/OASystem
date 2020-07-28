package com.geek.service;

import com.geek.bo.Departure_bo;
import com.geek.bo.PersonnelInformation_bo;
import com.geek.dao.EmpDao;
import com.geek.pojo.Emp;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    /**
     * 根据用户名查询
     * @param account
     * @return
     */
    @Transactional
    public Emp findEmpByAccount(String account){
        return empDao.findEmpByAccount(account);
    }

    public Emp findEmpById(int empId){
        return empDao.findEmpById(empId);
    }

    public void updateInformation(int empId,String head,String phone,String email){
        empDao.updateEmpById(empId,head,phone,email);
    }

    /**
     * 根据部门id查询部门经理
     * @return
     */
    public Emp findManagerBydepId(int depId){
        return empDao.findManagerBydepId(depId);
    }

    /**
     * 查询人事信息
     * @param start
     * @param end
     * @return
     */
    public List<Emp> findAll(int start,int end){
       return empDao.findAll(start,end);
    }

    /**
     * 员工总数
     * @return
     */
    public int findCount(){
        return empDao.findCount();
    }

    public List<Departure_bo> findDeparture(int start,int end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Departure_bo> list = new ArrayList<>();
        List<Emp> empList = empDao.findDeparture(start,end);
        for (Emp emp : empList) {
            Departure_bo departure_bo = new Departure_bo();
            departure_bo.setEmpId(emp.getEmpId());
            departure_bo.setEmpName(emp.getEmpName());
            departure_bo.setDepName(emp.getDep().getDepName());
            departure_bo.setPosition(emp.getPosition());
            departure_bo.setCheckEmpName("李浩");
            departure_bo.setLastTime(sdf.format(new Date()));

        }
        return list;
    }


}
