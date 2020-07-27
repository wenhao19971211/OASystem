package com.geek.handler;


import com.geek.bo.SalaryIssue_bo;
import com.geek.service.SalaryIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 薪资发放
 */

@Controller
public class SalaryIssueHandler {
    @Autowired
    private SalaryIssueService salaryIssueService;

    /**
     * 根据薪资发放状态查询薪资发放数据
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryIssueByStatus")
    @ResponseBody
    public SalaryIssue_bo findSalaryIssueByStatus(Integer status,Integer page,Integer limit)
    {
        SalaryIssue_bo salaryIssue_bo = salaryIssueService.findSalaryIssueByStatus(status, page, limit);
        return salaryIssue_bo;
    }

    /**
     * 根据id更新发放状态
     * @param salaryIssueId
     * @param status
     * @return
     */
    @PutMapping("updateSalaryIssueStatusBySalaryIssueId")
    @ResponseBody
    public String updateSalaryIssueStatusBySalaryIssueId(Integer salaryIssueId,Integer status)
    {
        boolean b1 = salaryIssueService.updateSalaryIssueStatusBySalaryIssueId(salaryIssueId, status);
        String flag = "success";
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }


}
