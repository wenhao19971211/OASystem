package com.geek.handler;

import com.geek.bo.Leave_bo;
import com.geek.dto.Result;
import com.geek.pojo.DayOff;
import com.geek.pojo.Dominant;
import com.geek.pojo.Emp;
import com.geek.service.EmpService;
import com.geek.service.LeaveService;
import com.geek.util.SessionNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 与假期有关
 */
@RestController
public class HolidayHandler {
    @Autowired
    LeaveService leaveService;
    @Autowired
    EmpService empService;
    @PostMapping("leave")
    public Integer addLeaveAndAddMessage(int type, String startDate, String endDate, String cause, HttpSession session){
//        时间转化,字符转转date
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date startTime=null;
        Date endTime=null;
        try {
            startTime=sdf.parse(startDate);
            endTime=sdf.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("进入了");
        System.out.println(type+"  "+startDate+"  "+endDate+"  "+cause);
        Emp emp= (Emp) session.getAttribute(SessionNameUtil.Login_User);
        //审核人的Id
        int managerId=empService.findManagerBydepId(emp.getDep().getDepId()).getEmpId();
        //传递
        leaveService.addLeave(type,emp.getEmpId(),cause,startTime,endTime,managerId);
        return 1;
    }

    /**
     * 根据员工编号获取可支配的时间
     * @param empId
     * @return
     */
    @GetMapping("leaveInfo/{empId}")
    public Dominant findLeaveTime(@PathVariable("empId") int empId){
        System.out.println(empId);
        System.out.println("进入了可支配的时间");
        //获取可支配的时间对象
        Dominant dominant=leaveService.findDominantByEmpId(empId);
        return dominant;
    }

    /**
     * 个人查看时显示的自己请的假,审核情况
     * @param empId
     * @return
     */
    @GetMapping("leaveList/{empId}")
    public Result findLeaveList(@PathVariable("empId") int empId){
        System.out.println("进入了list");
        Result result=new Result();
        List<Leave_bo>leaveList=leaveService.findLeaveList(0,empId,0);
        result.setList(leaveList);
        return result;
    }

    /**
     * 经理使用与上一个同功能
     * @param depId
     * @return
     */
    @GetMapping("leaveAudit/{depId}")
    public Result findAllLeaveByStateAndDepId(@PathVariable("depId")int depId){
        Result result=new Result();
        List<Leave_bo>list=leaveService.findLeaveList(depId,0,1);
        result.setList(list);
        return result;
    }



}
