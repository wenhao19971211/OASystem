package com.geek.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.geek.bo.TaskReceive_bo;
import com.geek.bo.TaskReceive_detail_bo;
import com.geek.bo.TaskSend_bo;
import com.geek.bo.TaskSend_detail_bo;
import com.geek.pojo.Emp;
import com.geek.pojo.Message;
import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import com.geek.service.EmpService;
import com.geek.service.TaskSendService;
import com.geek.util.CommonUtil;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TaskSendHandler {
    @Autowired
    private TaskSendService taskSendService;
    @Autowired
    private EmpService empService;

    /**
     * 新增任务
     * @param loginEmp
     * @param title
     * @param content
     * @param startTime
     * @param finishTime
     * @param receiveEmpIds
     * @return
     */
    @PostMapping("addTask")
    @ResponseBody
    public String addTask( @SessionAttribute("loginEmp") Emp loginEmp, String title, String content, String startTime, String finishTime, Integer[] receiveEmpIds)
    {
        //需要从session中获取当前用户

        //Integer[] receiveEmpIds = new Integer[]{2,3};
        System.out.println("进入addTask");
        String flag = "success";
        //创建任务发放
        Date today = new Date();
        TaskSend taskSend = new TaskSend();
        taskSend.setEmpId(loginEmp.getEmpId());
        taskSend.setToday(today);
        taskSend.setTitle(title);
        taskSend.setContent(content);
        taskSend.setStartTime(CommonUtil.parseDate(startTime));
        taskSend.setFinishTime(CommonUtil.parseDate(finishTime));
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
    public String finishTask(Integer taskReceiveId,Integer status)
    {
        String flag = "success";
        //任务状态：1、进行中；2、已完成；
        boolean b1 = taskSendService.updateStatusByTaskReceiveId(taskReceiveId, status);
        if (!b1)
        {
            flag = "failed";
        }
        return flag;
    }



    /**
     * 根据状态和登录人id查询接收任务的详情（显示任务发布表中的数据），任务完成情况显示自己的任务完成情况（进行中）
     * @param loginEmp
     * @param status
     * @return
     */
    @GetMapping("findTaskByStatus1")
    @ResponseBody
    public String findTaskByStatus1(@SessionAttribute("loginEmp") Emp loginEmp,Integer status,Integer page,Integer limit )
    {
        //需要从session中获取当前用户
        status = 1;
        if (page == null)
        {
            page = 1;
        }

        //需要从session中获取当前用户
        TaskReceive_bo taskReceive_bo = taskSendService.findTaskReceivesByStatus(status, loginEmp.getEmpId(), page,limit);
        //return taskReceive_bo;

        List<TaskReceive_detail_bo> taskReceive_detail_bos = new ArrayList<TaskReceive_detail_bo>();
        if (taskReceive_bo.getTaskReceives() != null && taskReceive_bo.getTaskReceives().size() != 0)
        {
            for (TaskReceive taskReceive : taskReceive_bo.getTaskReceives()) {
                TaskReceive_detail_bo taskReceive_detail_bo = new TaskReceive_detail_bo();
                taskReceive_detail_bo.setTaskSendId(taskReceive.getTaskSendId());
                taskReceive_detail_bo.setTaskSendEmpName(taskReceive.getTaskSend().getEmp().getEmpName());
                taskReceive_detail_bo.setTitle(taskReceive.getTaskSend().getTitle());
                taskReceive_detail_bo.setContent(taskReceive.getTaskSend().getContent());
                taskReceive_detail_bo.setStartTime(CommonUtil.dateToString(taskReceive.getTaskSend().getStartTime()));
                taskReceive_detail_bo.setFinishTime(CommonUtil.dateToString(taskReceive.getTaskSend().getFinishTime()));
                taskReceive_detail_bo.setFactFinishTime(CommonUtil.dateToString(taskReceive.getFinishTime()));
                taskReceive_detail_bo.setTaskReceiveId(taskReceive.getTaskReceiveId());
                if(taskReceive.getStatus() == 1)
                {
                    taskReceive_detail_bo.setStatus("进行中");
                }
                else
                {
                    taskReceive_detail_bo.setStatus("完成");
                }
                taskReceive_detail_bos.add(taskReceive_detail_bo);

            }
        }


        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",taskReceive_bo.getNum());
        map.put("data",taskReceive_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }
    /**
     * 根据状态和登录人id查询接收任务的详情（显示任务发布表中的数据），任务完成情况显示自己的任务完成情况（完成）
     * @param loginEmp
     * @param status
     * @return
     */
    @GetMapping("findTaskByStatus2")
    @ResponseBody
    public String findTaskByStatus2(@SessionAttribute("loginEmp") Emp loginEmp,Integer status,Integer page,Integer limit )
    {
        //需要从session中获取当前用户
        status = 2;
        if (page == null)
        {
            page = 1;
        }

        //需要从session中获取当前用户
        TaskReceive_bo taskReceive_bo = taskSendService.findTaskReceivesByStatus(status, loginEmp.getEmpId(), page,limit);
        //return taskReceive_bo;

        List<TaskReceive_detail_bo> taskReceive_detail_bos = new ArrayList<TaskReceive_detail_bo>();
        if (taskReceive_bo.getTaskReceives() != null && taskReceive_bo.getTaskReceives().size() != 0)
        {
            for (TaskReceive taskReceive : taskReceive_bo.getTaskReceives()) {
                TaskReceive_detail_bo taskReceive_detail_bo = new TaskReceive_detail_bo();
                taskReceive_detail_bo.setTaskSendId(taskReceive.getTaskSendId());
                taskReceive_detail_bo.setTaskSendEmpName(taskReceive.getTaskSend().getEmp().getEmpName());
                taskReceive_detail_bo.setTitle(taskReceive.getTaskSend().getTitle());
                taskReceive_detail_bo.setContent(taskReceive.getTaskSend().getContent());
                taskReceive_detail_bo.setStartTime(CommonUtil.dateToString(taskReceive.getTaskSend().getStartTime()));
                taskReceive_detail_bo.setFinishTime(CommonUtil.dateToString(taskReceive.getTaskSend().getFinishTime()));
                taskReceive_detail_bo.setFactFinishTime(CommonUtil.dateToString(taskReceive.getFinishTime()));
                taskReceive_detail_bo.setTaskReceiveId(taskReceive.getTaskReceiveId());
                if(taskReceive.getStatus() == 1)
                {
                    taskReceive_detail_bo.setStatus("进行中");
                }
                else
                {
                    taskReceive_detail_bo.setStatus("完成");
                }
                taskReceive_detail_bos.add(taskReceive_detail_bo);

            }
        }


        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",taskReceive_bo.getNum());
        map.put("data",taskReceive_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;

    }









    /**
     * 根据登陆人id查询所发布的任务
     * @param loginEmp
     * @return
     */
    @GetMapping("findTaskByempId")
    @ResponseBody
    public String findTaskByempId(@SessionAttribute("loginEmp") Emp loginEmp, Integer page,Integer limit)
    {
        //需要从session中获取当前用户

        TaskSend_bo taskSend_bo = taskSendService.findTaskSendByEmpId(loginEmp.getEmpId(), page,limit);
        List<TaskSend_detail_bo> taskSend_detail_bos = new ArrayList<TaskSend_detail_bo>();

        if (taskSend_bo.getTaskSends() != null && taskSend_bo.getTaskSends().size() != 0)
        {
            for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
                TaskSend_detail_bo taskSend_detail_bo = new TaskSend_detail_bo();
                taskSend_detail_bo.setTaskSendId(taskSend.getTaskSendId());
                taskSend_detail_bo.setTitle(taskSend.getTitle());
                taskSend_detail_bo.setContent(taskSend.getContent());
                taskSend_detail_bo.setStartTime(CommonUtil.dateToString(taskSend.getStartTime()));
                taskSend_detail_bo.setFinishTime(CommonUtil.dateToString(taskSend.getFinishTime()));
                taskSend_detail_bo.setTaskSendEmpName(taskSend.getEmp().getEmpName());
                if (taskSend.getStatus() == 1)
                {
                    taskSend_detail_bo.setStatus("进行中");
                }
                else
                {
                    taskSend_detail_bo.setStatus("完成");
                }
                String taskReceiveEmpName = "";
                for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                    if ("".equals(taskReceiveEmpName))
                    {
                        taskReceiveEmpName = taskReceiveEmpName + taskReceive.getEmp().getEmpName();
                    }
                    else
                    {
                        taskReceiveEmpName = taskReceiveEmpName +","+ taskReceive.getEmp().getEmpName();
                    }

                }
                taskSend_detail_bo.setTaskReceiveEmpName(taskReceiveEmpName);
                taskSend_detail_bos.add(taskSend_detail_bo);
            }
        }




        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",taskSend_bo.getNum());
        map.put("data",taskSend_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;


    }

    /**
     * 根据当前登陆人模糊查询标题（包括发放人、接收人）
     * @param loginEmp
     * @param title
     * @param page
     * @return
     */
    @GetMapping("findTaskByTitle")
    @ResponseBody
    public String findTaskByTitle(@SessionAttribute("loginEmp") Emp loginEmp,String title,Integer page,Integer limit)
    {
        //需要从session中获取当前用户

        TaskSend_bo taskSend_bo = taskSendService.findTaskSendByTitle(loginEmp.getEmpId(), title, page,limit);
        List<TaskSend_detail_bo> taskSend_detail_bos = new ArrayList<TaskSend_detail_bo>();

        if (taskSend_bo.getTaskSends() != null && taskSend_bo.getTaskSends().size() != 0)
        {
            for (TaskSend taskSend : taskSend_bo.getTaskSends()) {
                TaskSend_detail_bo taskSend_detail_bo = new TaskSend_detail_bo();
                taskSend_detail_bo.setTaskSendId(taskSend.getTaskSendId());
                taskSend_detail_bo.setTitle(taskSend.getTitle());
                taskSend_detail_bo.setContent(taskSend.getContent());
                taskSend_detail_bo.setStartTime(CommonUtil.dateToString(taskSend.getStartTime()));
                taskSend_detail_bo.setFinishTime(CommonUtil.dateToString(taskSend.getFinishTime()));
                taskSend_detail_bo.setTaskSendEmpName(taskSend.getEmp().getEmpName());
                if (taskSend.getStatus() == 1)
                {
                    taskSend_detail_bo.setStatus("进行中");
                }
                else
                {
                    taskSend_detail_bo.setStatus("完成");
                }
                String taskReceiveEmpName = "";
                for (TaskReceive taskReceive : taskSend.getTaskReceives()) {
                    if ("".equals(taskReceiveEmpName))
                    {
                        taskReceiveEmpName = taskReceiveEmpName + taskReceive.getEmp().getEmpName();
                    }
                    else
                    {
                        taskReceiveEmpName = taskReceiveEmpName +","+ taskReceive.getEmp().getEmpName();
                    }

                }
                taskSend_detail_bo.setTaskReceiveEmpName(taskReceiveEmpName);
                taskSend_detail_bos.add(taskSend_detail_bo);
            }
        }




        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",taskSend_bo.getNum());
        map.put("data",taskSend_detail_bos);
        JSONObject o = (JSONObject) JSONObject.toJSON(map);
        String json = o.toJSONString();
        //System.out.println(json);
        return json;
    }

    @GetMapping("findfindOneDepAllEmpsByLoginEmp")
    @ResponseBody
    public List<Emp> findfindOneDepAllEmpsByLoginEmp(@SessionAttribute Emp loginEmp)
    {
        //System.out.println("loginEmp"+loginEmp);
        List<Emp> emps = empService.findOneDepAllEmpsByDepId(loginEmp.getEmpId());
        //System.out.println(emps.size());
        return emps;
    }


}
