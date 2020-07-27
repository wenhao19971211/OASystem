package com.geek.handler;

import com.alibaba.fastjson.JSONObject;
import com.geek.bo.CheckWork_bo;
import com.geek.bo.Contract_bo;
import com.geek.bo.PersonnelInformation_bo;
import com.geek.dto.Result;
import com.geek.pojo.CheckWork;
import com.geek.pojo.Contract;
import com.geek.pojo.Emp;
import com.geek.pojo.WorkOn;
import com.geek.service.CheckWorkService;
import com.geek.service.ContractService;
import com.geek.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * 人事合同（集合）
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("personnelInformation")
    public String personnelInformation(int page,int limit){
       int start = limit*(page-1)+1;
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
    @GetMapping("personnelContract")
    public String personnelContract(int page,int limit){
        int count = contractService.findCount();
        int start = limit*(page-1)+1;
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
        for (CheckWork_bo checkWork_bo : list) {
            System.out.println(checkWork_bo.getWorkInTime()+"\t"+checkWork_bo.getWorkOutTime());
        }
        result.setList(list);
        return result;
    }
    @GetMapping("prize")
    public Result prize(){
        Result result = new Result();
        return result;
    }
}
