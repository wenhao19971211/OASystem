package com.geek.handler;

import com.geek.bo.Salary_bo;
import com.geek.pojo.Salary;
import com.geek.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalaryHandler {
    @Autowired
    private SalaryService salaryService;


    /**
     * 查询员工的薪资
     * @param loginEmpId
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryByEmpId")
    @ResponseBody
    public Salary_bo findSalaryByEmpId(Integer loginEmpId,Integer page,Integer limit)
    {
        Salary_bo salary_bo = salaryService.findSalaryByEmpId(loginEmpId, page, limit);
        return salary_bo;
    }


}
