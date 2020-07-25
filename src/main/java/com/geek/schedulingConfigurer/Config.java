package com.geek.schedulingConfigurer;


import com.geek.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling//可以在启动类上注解也可以在当前文件
public class Config  {
    @Autowired
    private SalaryService salaryService;

    //每月10号01：02执行
    // 规则：
    // --秒（0~59）
    //分钟（0~59）
    //小时（0~23）
    //天（月）（0~31，但是你需要考虑你月的天数）
    //月（0~11）
    //天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
    //年份（1970－2099
    @Scheduled(cron = "0 2 1 10 * ?")
    public void runfirst(){

        System.out.println("********定时计算薪资******");
        boolean b = salaryService.updateLastMonthSalary(new Date());
        if (b)
        {
            System.out.println("上个月薪资计算成功");
        }
        else
        {
            System.out.println("上个月薪资计算出错，请及时人工补救");
        }
    }


/*

    //隔10秒执行一次
    @Scheduled(fixedRate = 1000 * 10)
    public void runsecend(){
        System.out.println("********定时器******");
    }
*/

/*
    //隔1秒后再调用
    @Scheduled(fixedDelay=1000)
    public void runThird(){
        System.out.println("********third job is ok*******");
    }

*/


}