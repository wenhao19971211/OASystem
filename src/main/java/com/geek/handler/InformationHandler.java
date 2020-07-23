package com.geek.handler;

import com.geek.dto.Result;
import com.geek.pojo.Emp;
import com.geek.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationHandler {
    @Autowired
    private EmpService empService;
    @GetMapping("seeEmp")
    public Result findInformation(int empId){
        Result result = new Result();
        Emp emp = empService.findEmpById(empId);
        result.setObject(emp);
        return result;
    }
    public Result updateInformation(int empId,String head,String phone,String email){
        Result result = new Result();
        empService.updateInformation(empId,head,phone,email);
        result.setCode(1);
        return result;
    }
}