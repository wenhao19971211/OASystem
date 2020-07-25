package com.geek.handler;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.geek.bo.PersonnelInformation_bo;
import com.geek.dto.Result;
import com.geek.pojo.Emp;
import com.geek.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 人事
 */
@RestController
public class PersonnelHandler {
    @Autowired
    private EmpService empService;

    /**
     * 人事合同
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
        System.out.println(json);
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
}
