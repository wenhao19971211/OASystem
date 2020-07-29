package com.geek.handler;


import com.alibaba.fastjson.JSONObject;
import com.geek.bo.RimbursementIssue_bo;
import com.geek.bo.RimbursementIssue_detail_bo;
import com.geek.pojo.Rimbursement;
import com.geek.service.RimbursementIssueService;
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
    public String findRimbursementByStatus(Integer status,Integer page,Integer limit)
    {
        System.out.println("handler:status:"+status);
        RimbursementIssue_bo rimbursementIssue_bo = rimbursementIssueService.findRimbursementByStatus(status, page, limit);

        List<RimbursementIssue_detail_bo> rimbursementIssue_detail_bos = new ArrayList<RimbursementIssue_detail_bo>();
        if (rimbursementIssue_bo.getRimbursements() != null && rimbursementIssue_bo.getRimbursements().size() != 0)
        {
            //System.out.println("handler:size:"+rimbursementIssue_bo.getRimbursements().size());
            for (Rimbursement rimbursement : rimbursementIssue_bo.getRimbursements()) {
                RimbursementIssue_detail_bo rimbursementIssue_detail_bo = new RimbursementIssue_detail_bo();
                if (rimbursement != null)
                {
                    rimbursementIssue_detail_bo.setRimbursementIssueId(rimbursement.getRimbursementIssue());
                    //System.out.println("handler:empName:"+rimbursement.getReimbursement().getEmp().getEmpName());
                    //System.out.println("handler:depName:"+rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setApplyEmpName(rimbursement.getReimbursement().getEmp().getEmpName());
                    rimbursementIssue_detail_bo.setApplyDepName(rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setSum(rimbursement.getReimbursement().getSum());
                    rimbursementIssue_detail_bo.setFactMoney(rimbursement.getFactMoney());
                    rimbursementIssue_detail_bo.setIssueTime(CommonUtil.dateToString(rimbursement.getIssueTime()));
                    if (rimbursement.getStatus() ==1)
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("未发放");
                    }
                    else
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("已发放");
                    }

                }
                rimbursementIssue_detail_bos.add(rimbursementIssue_detail_bo);
            }
        }



        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rimbursementIssue_bo.getCount());
        map.put("data",rimbursementIssue_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }


    /**
     * 根据发放状态为1查询所有的发放记录
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findRimbursementByStatus1")
    @ResponseBody
    public String findRimbursementByStatus1(Integer status,Integer page,Integer limit)
    {
        //System.out.println("handler:status:"+status);
        status = 1;
        RimbursementIssue_bo rimbursementIssue_bo = rimbursementIssueService.findRimbursementByStatus(status, page, limit);

        List<RimbursementIssue_detail_bo> rimbursementIssue_detail_bos = new ArrayList<RimbursementIssue_detail_bo>();
        if (rimbursementIssue_bo.getRimbursements() != null && rimbursementIssue_bo.getRimbursements().size() != 0)
        {
            //System.out.println("handler:size:"+rimbursementIssue_bo.getRimbursements().size());
            for (Rimbursement rimbursement : rimbursementIssue_bo.getRimbursements()) {
                RimbursementIssue_detail_bo rimbursementIssue_detail_bo = new RimbursementIssue_detail_bo();
                if (rimbursement != null)
                {
                    rimbursementIssue_detail_bo.setRimbursementIssueId(rimbursement.getRimbursementIssue());
                    //System.out.println("handler:empName:"+rimbursement.getReimbursement().getEmp().getEmpName());
                    //System.out.println("handler:depName:"+rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setApplyEmpName(rimbursement.getReimbursement().getEmp().getEmpName());
                    rimbursementIssue_detail_bo.setApplyDepName(rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setSum(rimbursement.getReimbursement().getSum());
                    rimbursementIssue_detail_bo.setFactMoney(rimbursement.getFactMoney());
                    rimbursementIssue_detail_bo.setIssueTime(CommonUtil.dateToString(rimbursement.getIssueTime()));
                    if (rimbursement.getStatus() ==1)
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("未发放");
                    }
                    else
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("已发放");
                    }

                }
                rimbursementIssue_detail_bos.add(rimbursementIssue_detail_bo);
            }
        }



        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rimbursementIssue_bo.getCount());
        map.put("data",rimbursementIssue_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }

    /**
     * 根据发放状态为2查询所有的发放记录
     * @param status
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findRimbursementByStatus2")
    @ResponseBody
    public String findRimbursementByStatus2(Integer status,Integer page,Integer limit)
    {
        //System.out.println("handler:status:"+status);
        status = 2;
        RimbursementIssue_bo rimbursementIssue_bo = rimbursementIssueService.findRimbursementByStatus(status, page, limit);

        List<RimbursementIssue_detail_bo> rimbursementIssue_detail_bos = new ArrayList<RimbursementIssue_detail_bo>();
        if (rimbursementIssue_bo.getRimbursements() != null && rimbursementIssue_bo.getRimbursements().size() != 0)
        {
            //System.out.println("handler:size:"+rimbursementIssue_bo.getRimbursements().size());
            for (Rimbursement rimbursement : rimbursementIssue_bo.getRimbursements()) {
                RimbursementIssue_detail_bo rimbursementIssue_detail_bo = new RimbursementIssue_detail_bo();
                if (rimbursement != null)
                {
                    rimbursementIssue_detail_bo.setRimbursementIssueId(rimbursement.getRimbursementIssue());
                    //System.out.println("handler:empName:"+rimbursement.getReimbursement().getEmp().getEmpName());
                    //System.out.println("handler:depName:"+rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setApplyEmpName(rimbursement.getReimbursement().getEmp().getEmpName());
                    rimbursementIssue_detail_bo.setApplyDepName(rimbursement.getReimbursement().getDep().getDepName());
                    rimbursementIssue_detail_bo.setSum(rimbursement.getReimbursement().getSum());
                    rimbursementIssue_detail_bo.setFactMoney(rimbursement.getFactMoney());
                    rimbursementIssue_detail_bo.setIssueTime(CommonUtil.dateToString(rimbursement.getIssueTime()));
                    if (rimbursement.getStatus() ==1)
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("未发放");
                    }
                    else
                    {
                        rimbursementIssue_detail_bo.setIssueStatus("已发放");
                    }

                }
                rimbursementIssue_detail_bos.add(rimbursementIssue_detail_bo);
            }
        }



        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",rimbursementIssue_bo.getCount());
        map.put("data",rimbursementIssue_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

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
        //System.out.println("rimbursementIssueId"+rimbursementIssueId+"--status:"+status);
        boolean b1 = rimbursementIssueService.updateRimbursementIssueStatusByRimbursementIssueId(rimbursementIssueId, status);
        String flag = "success";
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }




}
