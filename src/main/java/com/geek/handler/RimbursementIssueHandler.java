package com.geek.handler;


import com.geek.bo.RimbursementIssue_bo;
import com.geek.service.RimbursementIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
    报销发发放
 */
@Controller
public class RimbursementIssueHandler {
    @Autowired
    private RimbursementIssueService rimbursementIssueService;

    /**
     * 根据发放状态查询所有的发放记录
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findRimbursementByStatus")
    @ResponseBody
    public RimbursementIssue_bo findRimbursementByStatus(Integer status,Integer page,Integer limit)
    {
        RimbursementIssue_bo rimbursementIssue_bo = rimbursementIssueService.findRimbursementByStatus(status, page, limit);
        return rimbursementIssue_bo;
    }

    /**
     * 根据报销发放id更新发放状态
     * @param rimbursementIssueId
     * @param status
     * @return
     */
    @PutMapping("updateRimbursementIssueStatusByRimbursementIssueId")
    @ResponseBody
    public String updateRimbursementIssueStatusByRimbursementIssueId(Integer rimbursementIssueId,Integer status)
    {
        boolean b1 = rimbursementIssueService.updateRimbursementIssueStatusByRimbursementIssueId(rimbursementIssueId, status);
        String flag = "success";
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }




}
