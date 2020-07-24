package com.geek.handler;

import com.geek.bo.PersonnelInformation_bo;
import com.geek.dto.Result;
import com.geek.pojo.Emp;
import com.geek.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonnelHandler {
    @Autowired
    private EmpService empService;
    @GetMapping("personnelInformation")
    public Result personnelInformation(int page){
        Result result = new Result();
        PersonnelInformation_bo person;
        person = empService.findAll(page);
        List<Emp> list = person.getList();
        int pageCount = person.getPageCount();
        result.setList(list);
        result.setCode(pageCount);
        return result;
    }
}
