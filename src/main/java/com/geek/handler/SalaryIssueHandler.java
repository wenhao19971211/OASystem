package com.geek.handler;


import com.alibaba.fastjson.JSONObject;
import com.geek.bo.SalaryIssue_bo;
import com.geek.service.SalaryIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 薪资发放
 */

@Controller
public class SalaryIssueHandler {
    @Autowired
    private SalaryIssueService salaryIssueService;

    /**
     * 根据薪资发放状态查询薪资发放数据（未发放）
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryIssueByStatus")
    @ResponseBody
    public String findSalaryIssueByStatus1(Integer status,Integer page,Integer limit)
    {
        status = 1;
        SalaryIssue_bo salaryIssue_bo = salaryIssueService.findSalaryIssueByStatus(status, page, limit);
        //return salaryIssue_bo;
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",salaryIssue_bo.getCount());
        map.put("data",salaryIssue_bo.getSalaryIssues());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }

    /**
     * 根据薪资发放状态查询薪资发放数据（发放）
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryIssueByStatus")
    @ResponseBody
    public String findSalaryIssueByStatus2(Integer status,Integer page,Integer limit)
    {
        status = 2;
        SalaryIssue_bo salaryIssue_bo = salaryIssueService.findSalaryIssueByStatus(status, page, limit);
        //return salaryIssue_bo;
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",salaryIssue_bo.getCount());
        map.put("data",salaryIssue_bo.getSalaryIssues());
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }

    /**
     * 根据id更新发放状态
     * @param salaryIssueId
     * @param status
     * @return
     */
    @PutMapping("updateSalaryIssueStatusBySalaryIssueId")
    @ResponseBody
    public String updateSalaryIssueStatus1BySalaryIssueId(Integer salaryIssueId,Integer status)
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
