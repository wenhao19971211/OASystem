import com.geek.bo.*;
import com.geek.dao.*;
import com.geek.handler.RimbursementIssueHandler;
import com.geek.handler.SalaryHandler;
import com.geek.handler.SalaryIssueHandler;
import com.geek.handler.TaskSendHandler;
import com.geek.pojo.*;
import com.geek.service.SalaryService;
import com.geek.util.CommonUtil;
import com.sun.corba.se.impl.presentation.rmi.IDLNameTranslatorImpl;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Test {
    @Autowired
    private TaskSendHandler taskSendHandler;
    @Autowired
    private YearLeaveDao yearLeaveDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private DayOffDao dayOffDao;
    @Autowired
    private StandardSalaryDao standardSalaryDao;
    @Autowired
    private SalaryService salaryService;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private SalaryHandler salaryHandler;
    @Autowired
    private SalaryIssueHandler salaryIssueHandler;
    @Autowired
    private RimbursementIssueHandler rimbursementIssueHandler;

    @org.junit.Test
    public void test1()
    {
        Integer[] receiveEmpIds = new Integer[]{2,3};
        String flag = taskSendHandler.addTask(1, "ceshi", "ceshi", new Date(), new Date(), receiveEmpIds);
        System.out.println("flag:"+flag);
    }

    @org.junit.Test
    public void test2()
    {
        TaskReceive_bo task = taskSendHandler.findTaskByStatus(6, 1, 2);
        for (TaskReceive taskReceive : task.getTaskReceives()) {
            System.out.println("taskReceive:"+taskReceive);
            System.out.println("taskReceive.getTaskSend():"+taskReceive.getTaskSend());
        }
        System.out.println(task.getTotal());
    }
    @org.junit.Test
    public void test3()
    {
        TaskSend_bo taskSend_bo = taskSendHandler.findTaskByempId(1, 1);
        for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
            System.out.println("taskSend"+taskSend);
            for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                System.out.println("taskReceive"+taskReceive);
            }

        }
        System.out.println(taskSend_bo.getTotal());
    }
    @org.junit.Test
    public void test4()
    {
        System.out.println("test4");
        TaskSend_bo taskSend_bo = taskSendHandler.findTaskByTitle(1, "c", 1);
        System.out.println("size()"+taskSend_bo.getTaskSends().size());
        for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
            System.out.println("taskSend:"+taskSend);
            for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                System.out.println("taskReceive"+taskReceive);
            }
        }
    }
    @org.junit.Test
    public void test5()
    {
        String flag = taskSendHandler.finishTask(28);
        System.out.println("flag:"+flag);
    }

    @org.junit.Test
    public void test6()
    {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH);
        //System.out.println("month:"+month);
        c.set(Calendar.DATE,1);
        Date date2 = c.getTime();
        c.set(Calendar.MONTH,month-1);
        Date date1 = c.getTime();
        System.out.println(date1+"------"+date2);

    }
    @org.junit.Test
    public void  test7()
    {
        List<DayOff> dayOffs = dayOffDao.findDayOffsByEmpIdAndStartAndEnd(1, CommonUtil.parseDate("2020-07-01 00:02:00"), CommonUtil.parseDate("2020-08-01 00:02:00"));
        System.out.println(dayOffs.size());
        for (DayOff dayOff : dayOffs) {
            System.out.println("dayoff"+dayOff.getDayOffId());
        }
        List<Leave> leaves = leaveDao.findLeavesByEmpIdAndStartAndEnd(1, CommonUtil.parseDate("2020-07-01 00:02:00"), CommonUtil.parseDate("2020-08-01 00:02:00"));
        System.out.println(leaves.size());
        for (Leave leaf : leaves) {
            System.out.println(leaf.getLeaveId());
        }

        List<YearLeave> yearLeaves = yearLeaveDao.findYearLeavesByEmpIdAndStartAndEnd(1, CommonUtil.parseDate("2020-07-01 00:02:00"), CommonUtil.parseDate("2020-08-01 00:02:00"));
        System.out.println(yearLeaves.size());
        for (YearLeave yearLeaf : yearLeaves) {
            System.out.println(yearLeaf.getYearLeaveId());
        }
    }
    
    @org.junit.Test
    public void test8()
    {
       // int request = CommonUtil.request("20200402");
        //System.out.println("request:"+request);
/*

        int workDay = CommonUtil.getMonthDayCountByDate(new Date());
        System.out.println("workDay:"+workDay);
*/
//        int workDay = CommonUtil.getWorkDay(new Date());
//        System.out.println("workDay:"+workDay);

        Contract contract = contractDao.findContractByEmpId(1);
        System.out.println(contract);

    }

    @org.junit.Test
    public void test9()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        //int month = calendar.get(Calendar.MONTH);
        //calendar.set(Calendar.MONTH,month-1);
        Date time = calendar.getTime();
        boolean b = salaryService.updateLastMonthSalary(time);
        System.out.println(b);
    }
    @org.junit.Test
    public void test10()
    {
       /*
        Salary_bo salary_bo = salaryHandler.findSalaryByEmpId(1, 1, 1);
        System.out.println("empId:"+salary_bo.getEmpId());
        System.out.println("count:"+salary_bo.getCount());
        for (Salary salary : salary_bo.getSalaries()) {
            System.out.println(salary);
        }*/
    }
    @org.junit.Test
    public void test11()
    {
        SalaryIssue_bo salaryIssue_bo = salaryIssueHandler.findSalaryIssueByStatus(1, 1, 3);
        System.out.println("status:"+salaryIssue_bo.getStatus());
        System.out.println("count:"+salaryIssue_bo.getCount());
        for (SalaryIssue salaryIssue : salaryIssue_bo.getSalaryIssues()) {
            System.out.println(salaryIssue);
        }
    }
    @org.junit.Test
    public  void test12()
    {
        RimbursementIssue_bo rimbursementIssue_bo = rimbursementIssueHandler.findRimbursementByStatus(2, 1, 3);
        System.out.println("count:"+rimbursementIssue_bo.getCount());
        for (Rimbursement rimbursement : rimbursementIssue_bo.getRimbursements()) {
            System.out.println(rimbursement);
        }
    }
    @org.junit.Test
    public void test13()
    {
        String flag = rimbursementIssueHandler.updateRimbursementIssueStatusByRimbursementIssueId(6, 2);
        System.out.println("flag:"+flag);
    }
    @org.junit.Test
    public  void test14()
    {
        String flag = salaryIssueHandler.updateSalaryIssueStatusBySalaryIssueId(19, 1);
        System.out.println("flag:"+flag);
    }
    @Autowired
    private DockPayDao dockPayDao;

    @org.junit.Test
    public void test15()
    {
        DockPay dockPay = new DockPay(1,new Date(),1,100.00,"迟到");
        int count = dockPayDao.addDockPay(dockPay);
        System.out.println("count:"+count);
    }

}
