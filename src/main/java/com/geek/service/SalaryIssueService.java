package com.geek.service;

import com.geek.bo.SalaryIssue_bo;
import com.geek.dao.EmpDao;
import com.geek.dao.SalaryDao;
import com.geek.dao.SalaryIssueDao;
import com.geek.pojo.Emp;
import com.geek.pojo.Salary;
import com.geek.pojo.SalaryIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SalaryIssueService {
    @Autowired
    private SalaryIssueDao salaryIssueDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private EmpDao empDao;

    /**
     * 根据发放状态查询薪资发放数据
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    public SalaryIssue_bo findSalaryIssueByStatus(Integer status,Integer page,Integer pageSize)
    {
        //所有数据
        List<SalaryIssue> salaryIssueByStatuses = salaryIssueDao.findSalaryIssueByStatus(status, null, null);
        Integer count = 0;
        if (salaryIssueByStatuses != null && salaryIssueByStatuses.size() != 0)
        {
           count =  salaryIssueByStatuses.size();
        }
        //当页数据
        List<SalaryIssue> salaryIssues = salaryIssueDao.findSalaryIssueByStatus(status, pageSize * (page - 1), pageSize);
        //System.out.println("salaryIssues.size:"+salaryIssues.size());
        if (salaryIssues != null && salaryIssues.size() != 0)
        {
            //System.out.println("salaryIssues.size:"+salaryIssues.size());
            for (SalaryIssue salaryIssue : salaryIssues) {
                //添加负责人信息
                Emp emp = empDao.findEmpById(salaryIssue.getEmpId());
                //System.out.println("service："+emp);
                salaryIssue.setEmp(emp);
                //System.out.println("service:salaryIssue.getEmp():"+salaryIssue.getEmp());
                //添加薪资信息
                Salary salary = salaryDao.findSalaryBySalaryId(salaryIssue.getSalaryId());
                //System.out.println("salary:"+salary);
                //添加该薪资的员工信息
                Emp receiveEmp = empDao.findEmpById(salary.getEmpId());
                //System.out.println("receiveEmp"+receiveEmp);
                salary.setEmp(receiveEmp);
                salaryIssue.setSalary(salary);

            }
        }


        SalaryIssue_bo salaryIssue_bo = new SalaryIssue_bo();
        salaryIssue_bo.setCount(count);
        salaryIssue_bo.setStatus(status);
        salaryIssue_bo.setSalaryIssues(salaryIssues);
        return salaryIssue_bo;
    }

    /**
     * 根据id更新发放状态
     * @param salaryIssueId
     * @param status
     * @return
     */
    public boolean updateSalaryIssueStatusBySalaryIssueId(Integer salaryIssueId,Integer status)
    {
        int count = salaryIssueDao.updateSalaryIssueStatusBySalaryIssueId(salaryIssueId, status,new Date());
        return count>0;
    }


}
