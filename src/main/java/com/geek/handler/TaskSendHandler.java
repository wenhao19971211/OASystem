package com.geek.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geek.bo.TaskReceive_bo;
import com.geek.bo.TaskSend_bo;
import com.geek.pojo.Emp;
import com.geek.pojo.Message;
import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import com.geek.service.TaskSendService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class TaskSendHandler {
    @Autowired
    private TaskSendService taskSendService;


    /**
     * 新增任务
     * @param loginEmpId
     * @param title
     * @param content
     * @param startTime
     * @param finishTime
     * @param receiveEmpIds
     * @return
     */
    @PostMapping("addTask")
    @ResponseBody
    public String addTask( Integer loginEmpId, String title, String content, Date startTime, Date finishTime, Integer[] receiveEmpIds)
    {
        //需要从session中获取当前用户

        //Integer[] receiveEmpIds = new Integer[]{2,3};

        String flag = "success";
        //创建任务发放
        Date today = new Date();
        TaskSend taskSend = new TaskSend();
        taskSend.setEmpId(loginEmpId);
        taskSend.setToday(today);
        taskSend.setTitle(title);
        taskSend.setContent(content);
        taskSend.setStartTime(startTime);
        taskSend.setFinishTime(finishTime);
        taskSend.setStatus(1);

        boolean b1 = taskSendService.addTaskSend(taskSend, receiveEmpIds);
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }

    /**
     * 根据接受任务的编号，完成任务
     *
     * @param taskReceiveId
     * @return
     */
    @PutMapping("finishTask")
    @ResponseBody
    public String finishTask(Integer taskReceiveId)
    {
        String flag = "success";
        //任务状态：1、进行中；2、已完成；
        boolean b1 = taskSendService.updateStatusByTaskReceiveId(taskReceiveId, 2);
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }



    /**
     * 根据状态和登录人id查询接收任务的详情（显示任务发布表中的数据），任务完成情况显示自己的任务完成情况
     * @param loginEmpId
     * @param status
     * @return
     */
    @GetMapping("findTaskByStatus")
    @ResponseBody
    public TaskReceive_bo findTaskByStatus(Integer loginEmpId,Integer status,Integer page )
    {
        //需要从session中获取当前用户

        if (page == null)
        {
            page = 1;
        }

        //需要从session中获取当前用户
        TaskReceive_bo taskReceive_bo = taskSendService.findTaskReceivesByStatus(status, loginEmpId, page);

        return taskReceive_bo;
    }

    /**
     * 根据登陆人id查询所发布的任务
     * @param loginEmpId
     * @return
     */
    @GetMapping("findTaskByempId")
    @ResponseBody
    public TaskSend_bo findTaskByempId(Integer loginEmpId, Integer page)
    {
        //需要从session中获取当前用户
        if (page == null)
        {
            page = 1;
        }
        TaskSend_bo taskSend_bo = taskSendService.findTaskSendByEmpId(loginEmpId, page);

        return taskSend_bo;
    }

    /**
     * 根据当前登陆人模糊查询标题（包括发放人、接收人）
     * @param loginEmpId
     * @param title
     * @param page
     * @return
     */
    @GetMapping("findTaskByTitle")
    @ResponseBody
    public TaskSend_bo findTaskByTitle(Integer loginEmpId,String title,Integer page)
    {
        //需要从session中获取当前用户
        if (page == null)
        {
            page = 1;
        }
        TaskSend_bo taskSend_bo = taskSendService.findTaskSendByTitle(loginEmpId, title, page);
        return taskSend_bo;
    }


}
