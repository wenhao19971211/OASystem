package com.geek.handler;

import com.geek.pojo.Dominant;
import com.geek.pojo.Emp;
import com.geek.service.EmpService;
import com.geek.service.LeaveService;
import com.geek.util.SessionNameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        //获取可支配的时间对象
        Dominant dominant=leaveService.findDominantByEmpId(empId);
        return dominant;
    }
}
