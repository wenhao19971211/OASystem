package com.geek.service;

import com.geek.bo.RimbursementIssue_bo;
import com.geek.dao.EmpDao;
import com.geek.dao.RimbursementIssueDao;
import com.geek.pojo.Emp;
import com.geek.pojo.Rimbursement;
import com.geek.pojo.SalaryIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 报销发放service
 */
@Service
public class RimbursementIssueService {
    
    @Autowired
    private RimbursementIssueDao rimbursementIssueDao;
    @Autowired
    private EmpDao empDao;
    /**
     * 根据发放状态查询所有的发放记录
     * @param status
     * @param page
     * @param pageSize
     * @return
     */
    public RimbursementIssue_bo findRimbursementByStatus(Integer status,Integer page,Integer pageSize)
    {
        //查询所有发放数据
        List<Rimbursement> rimbursementByStatuses = rimbursementIssueDao.findRimbursementByStatus(status, null, null);
        Integer count = 0;
        if (rimbursementByStatuses.size() != 0 && rimbursementByStatuses != null)
        {
            count = rimbursementByStatuses.size();
        }
        List<Rimbursement> rimbursements = rimbursementIssueDao.findRimbursementByStatus(status, page, pageSize);
        if (rimbursements != null && rimbursements.size() != 0)
        {
            for (Rimbursement rimbursement : rimbursements) {
                //添加负责人信息
                Emp emp = empDao.findEmpById(rimbursement.getEmpId());
                rimbursement.setEmp(emp);
            }
        }


        RimbursementIssue_bo rimbursementIssue_bo = new RimbursementIssue_bo();
        rimbursementIssue_bo.setStatus(status);
        rimbursementIssue_bo.setCount(count);
        rimbursementIssue_bo.setRimbursements(rimbursements);

        return rimbursementIssue_bo;


    }

    /**
     * 根据报销发放id更新发放状态
     * @param rimbursementIssueId
     * @param status
     * @return
     */
    public boolean updateRimbursementIssueStatusByRimbursementIssueId(Integer rimbursementIssueId,Integer status)
    {
        int count = rimbursementIssueDao.updateRimbursementIssueStatusByRimbursementIsuueId(rimbursementIssueId, status);
        return count>0;
    }

    
}
