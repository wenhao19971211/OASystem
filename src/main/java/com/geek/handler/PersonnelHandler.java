package com.geek.handler;

import com.alibaba.fastjson.JSONObject;
import com.geek.bo.CheckWork_bo;
import com.geek.bo.Contract_bo;
import com.geek.bo.PersonnelInformation_bo;
import com.geek.bo.Prize_bo;
import com.geek.dto.Result;
import com.geek.pojo.*;
import com.geek.service.CheckWorkService;
import com.geek.service.ContractService;
import com.geek.service.EmpService;
import com.geek.service.ReAndPuService;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 人事
 */
@RestController
public class PersonnelHandler {
    @Autowired
    private EmpService empService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private CheckWorkService checkWorkService;
    @Autowired
    private ReAndPuService reAndPuService;
    /**
     * 人事信息（集合）
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("personnelInformation")
    public String personnelInformation(int page,int limit){
       int start = limit*(page-1);
       int end = limit*page;
       int count = empService.findCount();
       List<Emp> list = empService.findAll(start,end);
       List<PersonnelInformation_bo> empList = new ArrayList<>();
        for (Emp emp : list) {
            PersonnelInformation_bo person = new PersonnelInformation_bo();
            person.setEmpId(emp.getEmpId());
            person.setEmpName(emp.getEmpName());
            person.setDepName(emp.getDep().getDepName());
            person.setPosition(emp.getPosition());
            String sex = "";
            if (emp.getSex()==1){
                sex="男";
            }
            else {
                sex="女";
            }
            person.setSex(sex);
            empList.add(person);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",empList);
       JSONObject o = (JSONObject) JSONObject.toJSON(map);
      String json = o.toJSONString();
       return json;
    }

    /**
     * 人事合同
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("personnelContract")
    public String personnelContract(int page,int limit){
        int count = contractService.findCount();
        int start = limit*(page-1);
        int end = limit*page;
        List<Contract_bo> list = contractService.findAll(start,end);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        return json;
    }

    /**
     * 个人详细信息
     * @param empId
     * @return
     */
    @GetMapping("empInfo")
    public Result empInfo(int empId){
        Result result = new Result();
        Emp emp = empService.findEmpById(empId);
        result.setObject(emp);
        return result;
    }

    /**
     * 个人合同信息
     * @param empId
     * @return
     */
    @GetMapping("contractInfo")
    public Result contractInfo(int empId){
        Result result = new Result();
        Contract contract = contractService.findContractByEmpId(empId);
        Emp emp =  empService.findEmpById(contract.getCheckEmp().getEmpId());
        contract.setCheckEmp(emp);
        System.out.println(emp.getEmpName());
        result.setObject(contract);
        return result;
    }

    /**
     * 个人考勤
     * @param empId
     * @return
     */
    @GetMapping("checkWork")
    public Result checkWork(int empId, long start,long end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse(sdf.format(new Date(start)));
            endTime = sdf.parse(sdf.format(new Date(end)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Result result = new Result();
        List<CheckWork_bo> list = checkWorkService.findById(empId,startTime,endTime);
        result.setList(list);
        return result;
    }
    @PutMapping("updateContract")
    public Result updateContract(int empId,int contractType,double salary,String start,String end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = sdf.parse(start);
            endTime = sdf.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        contractService.updateById(empId,salary,startTime,endTime,contractType);

        Result result = new Result();
        result.setCode(1);
        return result;
    }
    /**
     * 查看奖惩
     * @return
     */
    @GetMapping("prize")
    public Result prize(int empId){
        Result result = new Result();
        List<ReAndPu> list = reAndPuService.findById(empId);
        result.setList(list);
        return result;
    }

    /**
     * 查看全部奖惩
     * @return
     */
    @GetMapping("prizeList")
    public String prizeList(int page,int limit){
        int count = contractService.findCount();
        int start = limit*(page-1);
        int end = limit*page;
        List<Prize_bo> list = new ArrayList<>();
        List<ReAndPu> reAndPus = reAndPuService.findAll(start,end);
        for (ReAndPu reAndPu : reAndPus) {
            String type = "";
            String item = "";
            if (reAndPu.getType() == 1){
                type = "奖励";
            }
            else {
                type = "惩罚";
            }
            if (reAndPu.getItem() == 1){
                item = "季度之星";
            }
            else if (reAndPu.getItem() == 2){
                item = "优秀员工";
            }
            else if (reAndPu.getItem() == 3){
                item = "优秀团队";
            }
            else if (reAndPu.getItem() == 4){
                item = "警告";
            }
            else{
                item = "严重警告";
            }
            Prize_bo prize_bo = new Prize_bo();
            prize_bo.setCompany("极客营");
            prize_bo.setType(type);
            prize_bo.setItem(item);
            prize_bo.setCause(reAndPu.getCause());
            prize_bo.setMoney(reAndPu.getMoney());
            prize_bo.setReAndPuTime(CommonUtil.parseString(reAndPu.getReAndPuTime()));
            list.add(prize_bo);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data",list);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        return json;
    }

}
