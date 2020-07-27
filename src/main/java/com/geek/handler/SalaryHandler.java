package com.geek.handler;

import com.alibaba.fastjson.JSONObject;
import com.geek.bo.Salary_bo;
import com.geek.bo.Salary_detail_bo;
import com.geek.pojo.DockPay;
import com.geek.pojo.Emp;
import com.geek.pojo.Salary;
import com.geek.service.DockPayService;
import com.geek.service.SalaryService;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.*;

@Controller
public class SalaryHandler {
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private DockPayService dockPayService;


    /**
     * 查询员工的薪资
     * @param loginEmp
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("findSalaryByEmpId")
    @ResponseBody
    public String findSalaryByEmpId(@SessionAttribute("loginEmp") Emp loginEmp, Integer page, Integer limit)
    {

        Salary_bo salary_bo = salaryService.findSalaryByEmpId(loginEmp.getEmpId(), page, limit);


        List<Salary_detail_bo> salary_detail_bos = new ArrayList<Salary_detail_bo>();
        for (Salary salary : salary_bo.getSalaries()) {
            //该月1号至下个月1号（相对的）
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(salary.getMonth());
            calendar.set(Calendar.DATE,1);
            Date start = calendar.getTime();
            calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+1);
            Date end = calendar.getTime();
            //根据薪水表，查询扣薪的详细情况
            List<DockPay> dockPays = dockPayService.findDockPayByEmpIdAndStartAndEnd(salary.getEmpId(), start, end);
            double lateArrivalMoney = 0;//迟到早退扣薪
            double absenteeismMoney = 0;//旷工扣薪
            double leaveMoney = 0;//事假扣薪
            double socialSecurityMoney = 0;//社保
            double individualIncomeTax = 0;//个人所得税
            if (dockPays != null && dockPays.size() != 0)
            {

                for (DockPay dockPay : dockPays) {
                    if (dockPay.getDockPayType() == 1)
                    {
                        lateArrivalMoney+=dockPay.getDockPayMoney();
                    }
                    else if (dockPay.getDockPayType() == 2)
                    {
                        absenteeismMoney+=dockPay.getDockPayMoney();
                    }
                    else if (dockPay.getDockPayType() == 3)
                    {
                        leaveMoney+=dockPay.getDockPayMoney();
                    }
                    else if (dockPay.getDockPayType() == 4)
                    {
                        socialSecurityMoney+=dockPay.getDockPayMoney();
                    }
                    else if (dockPay.getDockPayType() == 5)
                    {
                        individualIncomeTax+=dockPay.getDockPayMoney();
                    }
                }
            }


            Salary_detail_bo salary_detail_bo = new Salary_detail_bo();
            //添加薪水
            salary_detail_bo.setEmpId(salary.getEmpId());
            salary_detail_bo.setSalaryId(salary.getSalaryId());
            salary_detail_bo.setBaseSalary(salary.getBaseSalary());
            salary_detail_bo.setPerSalary(salary.getPerSalary());
            salary_detail_bo.setMonth(CommonUtil.dateToMonthString(salary.getMonth()));
            //添加扣薪
            salary_detail_bo.setLateArrivalMoney(lateArrivalMoney);
            salary_detail_bo.setAbsenteeismMoney(absenteeismMoney);
            salary_detail_bo.setLeaveMoney(leaveMoney);
            salary_detail_bo.setSocialSecurityMoney(socialSecurityMoney);
            salary_detail_bo.setIndividualIncomeTax(individualIncomeTax);


            salary_detail_bos.add(salary_detail_bo);


        }

        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",salary_bo.getCount());
        map.put("data",salary_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        System.out.println(json);
        return json;
    }


}
