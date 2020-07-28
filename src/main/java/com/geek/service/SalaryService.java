package com.geek.service;

import com.geek.bo.Salary_bo;
import com.geek.dao.*;
import com.geek.handler.TaskSendHandler;
import com.geek.pojo.*;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private StandardSalaryDao standardSalaryDao;
    @Autowired
    private WorkOnDao workOnDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private YearLeaveDao yearLeaveDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private DayOffDao dayOffDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private SalaryIssueDao salaryIssueDao;
    @Autowired
    private DockPayDao dockPayDao;

    /**
     * 计算所有员工上个月的薪资
     * @return
     */
    @Transactional
    public boolean updateLastMonthSalary(Date date)
    {
        boolean flag = true;

        //获取当月的月份，0到11
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        //当月1号
        c.set(Calendar.DATE,1);
        Date date2 = c.getTime();
        //上个月1号
        c.set(Calendar.MONTH,month-1);
        Date date1 = c.getTime();
        //上个月：上个月1号至这个月1号
        //System.out.println(date1+"------"+date2);
        //获取上个月工作日
        int workDay = CommonUtil.getWorkDay(date1);
        //创建薪资发放
        List<SalaryIssue> salaryIssues = new ArrayList<SalaryIssue>();

        //查询员工薪资标准表
        List<StandardSalary> allStandardSalary = standardSalaryDao.findAllStandardSalary();
        if (allStandardSalary != null && allStandardSalary.size() != 0)
        {
            for (StandardSalary standardSalary : allStandardSalary) {
                //创建该员工的薪资发放清单
                SalaryIssue salaryIssue = new SalaryIssue();

                double absenteeismDay = 0;//旷工的天数
                double leaveDay = 0;//事假天数
                double dayOffDay = 0;//调休天数
                double yearLeaveDay = 0;//年薪天数
                double absenteeismMoney = 0;//旷工扣除的薪资
                double lateArrivalMoney = 0;//早退迟到应该扣除的薪资
                double leaveMoney = 0;//事假扣除的薪资
                double baseSalary = standardSalary.getBaseSalary();//该月应得的基本薪资
                double perSalary = standardSalary.getPerSalary();//该月应得的绩效薪资
                Date start = date1;
                Date end = date2;
                //查询人事合同表，读取生效时间，与打卡记录时间进行比较，如果生效时间是在上个月，打卡记录查询，从合同生效时间到这个月1号，得到员工上个月应得的月薪
                Contract contract = contractDao.findContractByEmpId(standardSalary.getEmpId());

                //如果该员工是在上个月入职的
                if (contract.getEffectTime().getTime()>start.getTime()&&contract.getEffectTime().getTime()<end.getTime())
                {
                    //考勤时间从合同生效时间开始
                    start = contract.getEffectTime();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(start);
                    //获取实际应得的基本薪资
                    baseSalary = standardSalary.getBaseSalary()*(31 - calendar.get(Calendar.DATE))/31;
                    //获取实际应得的绩效工资
                    perSalary = standardSalary.getPerSalary()*(31 - calendar.get(Calendar.DATE))/31;
                }else if (contract.getEffectTime().getTime()>end.getTime())
                {
                    //本月入职的不计算薪资，直接下一个员工计算
                    continue;
                }
                //如果该员工在上个月离职
                if (contract.getFailureTime().getTime()>start.getTime()&&contract.getFailureTime().getTime()<end.getTime())
                {
                    //考勤时间到合同失效时间截至
                    end = contract.getFailureTime();

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(end);
                    //获取实际应得的基本薪资
                    baseSalary = standardSalary.getBaseSalary()*(calendar.get(Calendar.DATE)-0)/31;
                    //获取实际应得的绩效工资
                    perSalary = standardSalary.getPerSalary()*(calendar.get(Calendar.DATE)-0)/31;

                }

                //根据时间段查询该员工的打卡表
                List<WorkOn> workOns = workOnDao.findWorkOnsByEmpIdAndMonth(standardSalary.getEmpId(), start, end);
                //该员工的工作时间
                double allWorkHour = 0;
                for (WorkOn workOn : workOns)
                {
                    //获取该员工当日的工作时间
                    double hour = ((double)workOn.getWorkOutTime().getTime() - workOn.getWorkInTime().getTime()) / (1000 * 60 * 60);
                    //上班时间8：00-17：00
                    if (hour>=9)
                    {
                        //正常打卡
                        allWorkHour+=8;
                    }
                    else if (hour>=8.75 && hour<9 )
                    {
                        //早退、迟到15分钟
                        allWorkHour+=8;
                        //扣20
                        lateArrivalMoney +=20;
                    }
                    else if (hour>=8.5&&hour<8.75)
                    {
                        //早退、迟到半小时
                        allWorkHour+=8;
                        //扣50
                        lateArrivalMoney+=50;
                    }
                    else if (hour >=7 && hour <8.5)
                    {
                        //早退、迟到两小时
                        allWorkHour+=8;
                        //扣200
                        lateArrivalMoney+=200;
                    }

                }
                //查询事假表
                List<Leave> leaves = leaveDao.findLeavesByEmpIdAndStartAndEnd(standardSalary.getEmpId(), start, end);

                for (Leave leaf : leaves) {
                    //单次事假天数
                    double oneLeaveDay = ( (double) leaf.getEndTime().getTime() - leaf.getStartTime().getTime()) / (1000 * 60 * 60 * 24);
                    //事假总天数
                    leaveDay+=Math.ceil(oneLeaveDay);
                }
                if (leaveDay<10)
                {
                    //扣除（总薪资/22天*24小时）*事假天数
                    leaveMoney+=((standardSalary.getBaseSalary()+standardSalary.getPerSalary())/22)*leaveDay;
                }
                else
                {
                    //超过10天（含10天）-扣除当月60%工资（每超过一天在扣除60%的基础上扣除天数工资，扣完为止）
                    leaveMoney+=((standardSalary.getBaseSalary()+standardSalary.getPerSalary())*0.6)+((standardSalary.getBaseSalary()+standardSalary.getPerSalary())/22)*(leaveDay-10);
                }

                //查询调休表
                List<DayOff> dayOffs = dayOffDao.findDayOffsByEmpIdAndStartAndEnd(standardSalary.getEmpId(), start, end);
                for (DayOff dayOff : dayOffs) {
                    //一次调休的天数
                    double oneDayOff = Math.ceil((double) dayOff.getEndTime().getTime() - dayOff.getStartTime().getTime()) / (1000 * 60 * 60*24);
                    //总调休时长
                    dayOffDay+=oneDayOff;
                }
                //查询年假表
                List<YearLeave> yearLeaves = yearLeaveDao.findYearLeavesByEmpIdAndStartAndEnd(standardSalary.getEmpId(), start, end);
                for (YearLeave yearLeaf : yearLeaves) {
                    //一次年假时长
                    double oneYearLeaf = ((double) yearLeaf.getEndTime().getTime() - yearLeaf.getStartTime().getTime()) / (1000 * 60 * 60 * 24);
                    //总年假时长
                    yearLeaveDay+=oneYearLeaf;
                }
                //判断旷工情况
                double factWorkDay = allWorkHour / 8 + leaveDay + dayOffDay + yearLeaveDay;
                if (factWorkDay<workDay)
                {
                    //旷工天数
                    absenteeismDay = Math.ceil(workDay - factWorkDay);
                    if (absenteeismDay<3)
                    {

                        absenteeismMoney = (standardSalary.getBaseSalary() + standardSalary.getPerSalary()) * 0.3 * absenteeismDay;
                    }
                    else
                    {
                        absenteeismMoney = (standardSalary.getBaseSalary() + standardSalary.getPerSalary());
                    }
                }

                //扣除事假、旷工、早退迟到，最后薪资情况
                double punishMoney = absenteeismMoney + leaveMoney + lateArrivalMoney;



                //具体薪资
                if(punishMoney>perSalary)
                {
                    perSalary = 0;
                    baseSalary = baseSalary - punishMoney;
                    if (baseSalary <= 0)
                    {
                        baseSalary = 0;
                    }
                }
                else
                {
                    perSalary = perSalary - punishMoney;
                }
                //扣除个人所得税和社保
                double socialSecurityMoney = (perSalary + baseSalary) * 0.11;
                //个人所得税
                double individualIncomeTax = 0;
                if((perSalary+baseSalary)>5000 && (perSalary+baseSalary)<=10000)
                {
                    individualIncomeTax = (perSalary + baseSalary) * 0.03;
                }
                else if ((perSalary+baseSalary)>10000)
                {
                    individualIncomeTax = (perSalary + baseSalary) *0.1;
                }
                //先扣绩效，再扣基本薪资
                if (perSalary>individualIncomeTax)
                {
                    perSalary = perSalary - individualIncomeTax;
                }
                else if (baseSalary > individualIncomeTax)
                {
                    perSalary = 0;
                    baseSalary -= individualIncomeTax;
                }
                else
                {
                    perSalary = 0;
                    baseSalary = 0;
                }



                //添加扣薪表
                if (absenteeismMoney > 0)
                {
                    //旷工扣薪
                    DockPay dockPay = new DockPay(standardSalary.getEmpId(),start,2,absenteeismMoney,"旷工"+absenteeismDay+"天");
                    int count = dockPayDao.addDockPay(dockPay);
                    if (count<=0)
                    {
                        flag = false;
                    }
                }
                if (leaveMoney > 0)
                {
                    //事假扣薪
                    DockPay dockPay = new DockPay(standardSalary.getEmpId(),start,3,leaveMoney,"事假"+leaveDay+"天");
                    int count = dockPayDao.addDockPay(dockPay);
                    if (count<=0)
                    {
                        flag = false;
                    }
                }
                if (lateArrivalMoney > 0)
                {
                    //迟到早退扣薪
                    DockPay dockPay = new DockPay(standardSalary.getEmpId(),start,1,lateArrivalMoney,"迟到早退");
                    int count = dockPayDao.addDockPay(dockPay);
                    if (count<=0)
                    {
                        flag = false;
                    }
                }
                if (socialSecurityMoney > 0)
                {
                    //五险一金
                    DockPay dockPay = new DockPay(standardSalary.getEmpId(),start,4,socialSecurityMoney,"社保");
                    int count = dockPayDao.addDockPay(dockPay);
                    if (count<=0)
                    {
                        flag = false;
                    }
                }
                if (individualIncomeTax > 0)
                {
                    //个人所得税
                    DockPay dockPay = new DockPay(standardSalary.getEmpId(),start,5,individualIncomeTax,"个人所得税");
                    int count = dockPayDao.addDockPay(dockPay);
                    if (count<=0)
                    {
                        flag = false;
                    }
                }

                //添加到薪酬表
                Salary salary = new Salary();
                salary.setEmpId(standardSalary.getEmpId());
                salary.setMonth(date1);
                salary.setBaseSalary(baseSalary);
                salary.setPerSalary(perSalary);
                int count1 = salaryDao.addSalaryByEmpIdAndMonth(salary);
                Integer salaryId = null;
                if (count1<1)
                {
                    flag = false;
                }
                else
                {
                    Salary salaryByEmpIdAndMonth = salaryDao.findSalaryByEmpIdAndMonth(salary.getEmpId(), salary.getMonth());
                    salaryId = salaryByEmpIdAndMonth.getSalaryId();
                }
                //添加到薪酬发放表
                salaryIssue.setEmpId(salary.getEmpId());
                salaryIssue.setIssueMoney(salary.getBaseSalary()+salary.getPerSalary());
                salaryIssue.setIssueTime(new Date());
                salaryIssue.setSalaryId(salaryId);
                salaryIssue.setStatus(1);
                //添加薪资发放表
                int count2 = salaryIssueDao.addSalaryIssue(salaryIssue);
                if (count2<=0)
                {
                    flag = false;
                }


            }
        }



        return flag;
    }

    /**
     * 根据员工id查询所有月的薪资
     * @param empId
     * @param page
     * @param pageSize
     * @return
     */
    public Salary_bo findSalaryByEmpId(Integer empId, Integer page, Integer pageSize)
    {
        //所有薪资
        List<Salary> salaryByEmpIds = salaryDao.findSalaryByEmpId(empId, null, null);


        Integer count = 0;
        if (salaryByEmpIds != null && salaryByEmpIds.size() != 0)
        {
            count = salaryByEmpIds.size();
        }
        //当页数据
        List<Salary> salaries = salaryDao.findSalaryByEmpId(empId, pageSize * (page - 1), pageSize);
       /* for (Salary salary : salaries) {
            System.out.println("service:"+salary.getMonth());
        }*/


        Salary_bo salary_bo = new Salary_bo();
        salary_bo.setEmpId(empId);
        salary_bo.setSalaries(salaries);
        salary_bo.setCount(count);

        return salary_bo;

    }





}
