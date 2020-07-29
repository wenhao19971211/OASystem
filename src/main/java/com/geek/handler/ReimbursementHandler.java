package com.geek.handler;

import com.alibaba.fastjson.JSONObject;
import com.geek.bo.ReimbursementAll_bo;
import com.geek.bo.Reimbursement_bo;
import com.geek.dto.Result;
import com.geek.service.ReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ReimbursementHandler {
    @Autowired
        ReimbursementService reimbursementService;

    /**
     * 传递页面的数据
     *
     * re.getReimbursementId(),re.getEmpId(),re.getTaskSendId(),re.getSendTime(),re.getSum()
     * @param
     * @return
     */
    @GetMapping("rmMessage")
    public Result insertEmpSomeMassge(int empId,int taskSendId,double sum,int type,String detail){
            Result result=new Result();
            Date date=new Date();
            reimbursementService.insertByEmpId(empId,taskSendId,date,sum,type,detail);
            System.out.println("提交成功");
            result.setMessage("提交成功");
        return result;
    }

    /**
     * 1、未审核；2、审核通过，等待报销费用下发； 3、报销费用已下发；4、审核未通过；5、未通过；
     *     private Integer reimbursementId;
     *     private Emp emp;
     *     private TaskSend taskSend;
     *     private Date sendTime;
     *     private double sum;
     *     private Date checkTime;
     *     private Integer checkStatus;
     *
     *
     *      public Integer reimbursementId;
     *             public Integer empId;
     *             public Integer taskSendId;
     *             public Date sendTime;
     *             public double sum;
     *             public Integer type;
     *             public String detail;
     *             public String typeStatue;
     * @param
     * @return
     */
    @GetMapping("changeStatue")
    public String selectAllStatue(){
//        String mess="";
//            Result result=new Result();
        //System.out.println("statue:"+statue);
        Integer statue = 1;
            List<ReimbursementAll_bo> list=reimbursementService.selectAllStatue(statue);
            Map<String,Object> map=new HashMap<>();
            map.put("code",0);
            map.put("msg","");
            map.put("count",100);
            map.put("data",list);
            JSONObject o = (JSONObject) JSONObject.toJSON(map);
            String json = o.toJSONString();
        System.out.println(json);
        return json;
    }
//    @GetMapping()
//    public Result updateByStatue(int statue,int empId,int reimbursementId ){
//        Result result=new Result();
//        reimbursementService.updateByEmpId(statue,empId);
//        return result;
//    }

}

//            List<Reimbursement_bo> list12= new ArrayList<>();
//            int i=1;
//            Reimbursement_bo re=new Reimbursement_bo();
//        for (ReimbursementAll_bo reimbursementAllBo : list) {
//            re.setReimbursementId(reimbursementAllBo.getReimbursementId());
//            re.setEmpId(reimbursementAllBo.getEmpId());
//            re.setSendTime(reimbursementAllBo.getSendTime());
//            re.setSum(reimbursementAllBo.getSum());
//            re.setType(reimbursementAllBo.getCheckStatus());
//
//            int s= reimbursementAllBo.getCheckStatus();
//            switch (s){
//                case 1:
//                    re.setTypeStatue("未审核");
//                    break;
//                case 2:
//                    re.setTypeStatue("审核通过");
//                    break;
//                case 3:
//                    re.setTypeStatue("报销费用已下发");
//                    break;
//                case 4:
//                    re.setTypeStatue("审核未通过");
//                    break;
//                case 5:
//                    re.setTypeStatue("未通过");
//                    break;
//            }
//            list12.set(i,re);
//            i++;
//        };
//        result.setMessage("发送状态成功");
//        result.setObject(list);
//