package com.geek.service;

import com.geek.bo.RimbursementIssue_bo;
import com.geek.dao.EmpDao;
import com.geek.dao.RimbursementIssueDao;
import com.geek.pojo.Emp;
import com.geek.pojo.Reimbursement;
import com.geek.pojo.Rimbursement;
import com.geek.pojo.SalaryIssue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<Rimbursement> rimbursements = rimbursementIssueDao.findRimbursementByStatus(status, pageSize*(page-1), pageSize);
        if (rimbursements != null && rimbursements.size() != 0)
        {
            //System.out.println("service:size:"+rimbursements.size());
            for (Rimbursement rimbursement : rimbursements) {
                //添加负责人信息
                Emp emp = empDao.findEmpById(rimbursement.getEmpId());
                rimbursement.setEmp(emp);
                //添加报销表信息
                Reimbursement reimbursement = rimbursementIssueDao.findReimbursementByReimbursementId(rimbursement.getRimbursementId());
                rimbursement.setReimbursement(reimbursement);
                //System.out.println("service:reId:"+reimbursement.getReimbursementId());
                //System.out.println("service:empName:"+reimbursement.getEmp().getEmpName());
                //System.out.println("service:depname:"+reimbursement.getDep().getDepName());
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
    @Transactional
    public boolean updateRimbursementIssueStatusByRimbursementIssueId(Integer rimbursementIssueId,Integer status)
    {
        //更新报销发放表的状态
        int count1 = rimbursementIssueDao.updateRimbursementIssueStatusByRimbursementIsuueId(rimbursementIssueId, status);
        //更新报销表的状态
        int count2 = rimbursementIssueDao.updateReimbursementStatus4ByReimbursementId(rimbursementIssueId, 4);


        return count1>0&&count2>0;
    }

    
}
