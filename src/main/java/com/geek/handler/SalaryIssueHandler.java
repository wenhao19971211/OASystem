package com.geek.handler;


import com.alibaba.fastjson.JSONObject;
import com.geek.bo.SalaryIssue_bo;
import com.geek.bo.SalaryIssue_detail_bo;
import com.geek.pojo.SalaryIssue;
import com.geek.service.SalaryIssueService;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    @GetMapping("findSalaryIssueByStatus1")
    @ResponseBody
    public String findSalaryIssueByStatus1(Integer status,Integer page,Integer limit)
    {
        status = 1;
        SalaryIssue_bo salaryIssue_bo = salaryIssueService.findSalaryIssueByStatus(status, page, limit);

        List<SalaryIssue_detail_bo> salaryIssue_detail_bos = new ArrayList<SalaryIssue_detail_bo>();

        if (salaryIssue_bo.getSalaryIssues() != null && salaryIssue_bo.getSalaryIssues().size() != 0)
        {
            for (SalaryIssue salaryIssue : salaryIssue_bo.getSalaryIssues()) {
                SalaryIssue_detail_bo salaryIssue_detail_bo = new SalaryIssue_detail_bo();
                salaryIssue_detail_bo.setSalaryIssueId(salaryIssue.getSalaryIssueId());
                salaryIssue_detail_bo.setIssueEmpName(salaryIssue.getEmp().getEmpName());//发放负责人
                salaryIssue_detail_bo.setSalaryReceiveEmpName(salaryIssue.getSalary().getEmp().getEmpName());
                salaryIssue_detail_bo.setSalaryReceiveDepName(salaryIssue.getSalary().getEmp().getDep().getDepName());
                salaryIssue_detail_bo.setIssueMoney(salaryIssue.getIssueMoney());
                salaryIssue_detail_bo.setIssueTime(CommonUtil.dateToString(salaryIssue.getIssueTime()));
                if(salaryIssue.getStatus() == 1)
                {
                    salaryIssue_detail_bo.setStatus("未发放");
                }
                else
                {
                    salaryIssue_detail_bo.setStatus("已发放");
                }
                salaryIssue_detail_bos.add(salaryIssue_detail_bo);
            }
        }


        //return salaryIssue_bo;
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",salaryIssue_bo.getCount());
        map.put("data",salaryIssue_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }

    /**
     * 根据薪资发放状态查询薪资发放数据（未发放）
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryIssueByStatus2")
    @ResponseBody
    public String findSalaryIssueByStatus2(Integer status,Integer page,Integer limit)
    {
        status = 2;
        SalaryIssue_bo salaryIssue_bo = salaryIssueService.findSalaryIssueByStatus(status, page, limit);

        List<SalaryIssue_detail_bo> salaryIssue_detail_bos = new ArrayList<SalaryIssue_detail_bo>();

        if (salaryIssue_bo.getSalaryIssues() != null && salaryIssue_bo.getSalaryIssues().size() != 0)
        {
            for (SalaryIssue salaryIssue : salaryIssue_bo.getSalaryIssues()) {
                SalaryIssue_detail_bo salaryIssue_detail_bo = new SalaryIssue_detail_bo();
                salaryIssue_detail_bo.setSalaryIssueId(salaryIssue.getSalaryIssueId());
                salaryIssue_detail_bo.setIssueEmpName(salaryIssue.getEmp().getEmpName());//发放负责人
                //System.out.println(salaryIssue.getEmp().getEmpName());
                salaryIssue_detail_bo.setSalaryReceiveEmpName(salaryIssue.getSalary().getEmp().getEmpName());
                salaryIssue_detail_bo.setSalaryReceiveDepName(salaryIssue.getSalary().getEmp().getDep().getDepName());
                salaryIssue_detail_bo.setIssueMoney(salaryIssue.getIssueMoney());
                salaryIssue_detail_bo.setIssueTime(CommonUtil.dateToString(salaryIssue.getIssueTime()));
                if(salaryIssue.getStatus() == 1)
                {
                    salaryIssue_detail_bo.setStatus("未发放");
                }
                else
                {
                    salaryIssue_detail_bo.setStatus("已发放");
                }
                salaryIssue_detail_bos.add(salaryIssue_detail_bo);
            }
        }


        //return salaryIssue_bo;
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",salaryIssue_bo.getCount());
        map.put("data",salaryIssue_detail_bos);
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
