package com.geek.handler;


import com.geek.pojo.Emp;
import com.geek.service.TaskSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Date;

@Controller
public class TaskSendHandler {
    @Autowired
    private TaskSendService taskSendService;

    @GetMapping("addTask")
    public String addTask( Integer loginEmpId, String title, String content, Date startTime, Date finishTime/*, Integer[] receiveEmpIds*/)
    {
        //需要从session中获取当前用户

        Integer[] receiveEmpIds = new Integer[]{2,3};

        String flag = "success";
        boolean b1 = taskSendService.addTaskSend(loginEmpId, title, content, startTime, finishTime, receiveEmpIds);
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }


}
