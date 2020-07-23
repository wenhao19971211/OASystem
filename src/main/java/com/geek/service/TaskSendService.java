package com.geek.service;

import com.geek.bo.TaskReceive_bo;
import com.geek.bo.TaskSend_bo;
import com.geek.dao.MessageDao;
import com.geek.dao.TaskReceiveDao;
import com.geek.dao.TaskSendDao;
import com.geek.pojo.Message;
import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import com.geek.util.CommonUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 任务发放service
 */
@Service
public class TaskSendService {

    @Autowired
    private TaskSendDao taskSendDao;
    @Autowired
    private TaskReceiveDao taskReceiveDao;
    @Autowired
    private MessageDao messageDao;

    /**
     * 添加任务
     * @param taskSend
     * @param receiveEmpIds
     * @return
     */
    @Transactional
    public boolean addTaskSend(TaskSend taskSend,Integer... receiveEmpIds)
    {


        //添加任务发起
        int count1 = taskSendDao.addTaskSend(taskSend);

        if(count1>0)
        {
            //查询任务发起信息
            TaskSend taskSend1 = taskSendDao.findTaskSenndByEmpIdAndToday(taskSend.getEmpId(), taskSend.getToday());
            System.out.println("taskSend1:"+taskSend1);
            taskSend.setTaskSendId(taskSend1.getTaskSendId());
            System.out.println("taskSend:"+taskSend);

        }


        int count2 = 1;
        //添加任务接收
        for (Integer receiveEmpId : receiveEmpIds)
        {
            System.out.println("receiveEmpId:"+receiveEmpId);
            TaskReceive taskReceive = new TaskReceive();
            taskReceive.setEmpId(receiveEmpId);
            taskReceive.setTaskSendId(taskSend.getTaskSendId());
            taskReceive.setStatus(1);
            taskReceive.setFinishTime(null);

            //任务接收表中接收数据
            int count3 = taskReceiveDao.addTaskReceive(taskReceive);

            //添加消息表
            Message message = new Message();
            message.setMessageType(1);
            message.setMessageStatus(null);
            message.setReadStatus(1);
            message.setMessageContent(taskSend.getContent());
            message.setSendTime(taskSend.getToday());
            message.setEmpId(receiveEmpId);
            int count4 = messageDao.addMessage(message);


            if (count3 < 1 || count4 <1)
            {
                count2 = 0;
            }
        }
        return count1>0&&count2>0;
    }

    /**
     * 根据接受任务id，更改任务完成状态
     * @param taskReceiveId
     * @param status
     * @return
     */
    @Transactional
    public boolean updateStatusByTaskReceiveId(Integer taskReceiveId,Integer status)
    {
        //更新状态
        int count1 = taskReceiveDao.updateStatusByTaskReceiveId(taskReceiveId, status);
        //查询该任务接受数据
        TaskReceive taskReceive = taskReceiveDao.findTaskReceiveByTaskReceiveId(taskReceiveId);
        //查询到该任务发放数据
        TaskSend taskSend = taskSendDao.findTaskSendByTaskSendId(taskReceive.getTaskSendId());
        //根据任务发放id，查询到接收数据
        List<TaskReceive> taskReceives = taskReceiveDao.findTaskReceivesByTaskSendId(taskSend.getTaskSendId());
        //查看该发起的任务，其他接收人是否完成
        boolean flag = true;
        for (TaskReceive receive : taskReceives) {
            if (receive.getStatus() != status)
            {
                flag = false;
            }
        }
        //其他接收人都完成了,更新任务发放表的状态
        int count2 = 1;
        if (flag)
        {
            count2 = taskSendDao.updateStatusByTaskSendId(taskReceiveId, status);
        }

        return count1>0&&count2>0;

    }



    /**
     * 根据状态查询个人的任务
     * @param status
     * @param empId
     * @return
     */
    public TaskReceive_bo findTaskReceivesByStatus(Integer status,Integer empId,Integer page)
    {
        Integer pageSize = 5;
        int index = 1;
        if(page != null)
        {
            //每页显示多少条数据
            pageSize = CommonUtil.getPageSize();
            //该页显示的初始索引
            index = pageSize * (page - 1) ;
        }

        List<TaskReceive> taskReceivesByStatusAndEmpId = taskReceiveDao.findTaskReceivesByStatusAndEmpId(status, empId, null, null);
        //总页码
        int total = 0;

        if (taskReceivesByStatusAndEmpId != null && taskReceivesByStatusAndEmpId.size() != 0)
        {
            //数据总条数
            int size = taskReceivesByStatusAndEmpId.size();
            total = (int)Math.ceil((double) size/(double) CommonUtil.getPageSize());
        }


        //根据状态查询任务接收数据(页码)
        List<TaskReceive> taskReceives = taskReceiveDao.findTaskReceivesByStatusAndEmpId(status, empId,pageSize,index);
        //根据接收任务的数据查询关联的发送任务数据
        if (taskReceives != null && taskReceives.size() != 0)
        {
            for (TaskReceive taskReceive : taskReceives) {
                TaskSend taskSend = taskSendDao.findTaskSendByTaskSendId(taskReceive.getTaskSendId());
                taskReceive.setTaskSend(taskSend);
            }
        }
        //封装
        TaskReceive_bo taskReceive_bo = new TaskReceive_bo();
        taskReceive_bo.setTaskReceives(taskReceives);
        taskReceive_bo.setTotal(total);
        taskReceive_bo.setCount(CommonUtil.getPageSize());
        taskReceive_bo.setPage(page);


        return taskReceive_bo;
    }

    /**
     * 根据任务发送人id查询任务信息(包含接收任务信息)
     * @param empId
     * @return
     */
    public TaskSend_bo findTaskSendByEmpId(Integer empId,Integer page)
    {
        //该页起始数据的索引
        int index = CommonUtil.getPageSize() * (page - 1) ;
        //总页码
        int total = 0;
        List<TaskSend> taskSendByEmpId = taskSendDao.findTaskSendByEmpId(empId, null, null);
        if (taskSendByEmpId != null && taskSendByEmpId.size() != 0)
        {
            total = (int)Math.ceil((double) taskSendByEmpId.size()/(double)CommonUtil.getPageSize());
        }


        //查询任务发放信息
        List<TaskSend> taskSends = taskSendDao.findTaskSendByEmpId(empId,CommonUtil.getPageSize(),index);
        if (taskSends != null && taskSends.size() != 0)
        {
            for (TaskSend taskSend : taskSends) {
                List<TaskReceive> taskReceives = taskReceiveDao.findTaskReceivesByTaskSendId(taskSend.getTaskSendId());
                taskSend.setTaskReceives(taskReceives);
            }
        }

        TaskSend_bo taskSend_bo = new TaskSend_bo();
        taskSend_bo.setTaskSends(taskSends);
        taskSend_bo.setTotal(total);
        taskSend_bo.setPage(page);
        taskSend_bo.setCount(CommonUtil.getPageSize());

        return taskSend_bo;
    }


    /**
     * 根据任务标题查询相关任务（）当前登陆人至能查询到他作为任务发起人和接收人的所有任务
     * @param empId
     * @param title
     * @param page
     * @return
     */
    public TaskSend_bo findTaskSendByTitle(Integer empId,String title,Integer page)
    {
        //该页起始数据的索引
        int index = CommonUtil.getPageSize() * (page - 1) ;
        //总页码
        int total = 0;
        List<TaskSend> taskSendList = taskSendDao.findTaskSendByTitleAndReEmpIdAndSeEmpId(empId,"%"+ title+"%", null, null);
        //System.out.println("Listsize:"+taskSendList.size());
        if (taskSendList != null && taskSendList.size() != 0)
        {
            total = (int)Math.ceil((double) taskSendList.size()/(double)CommonUtil.getPageSize());
        }
        //该页任务数据
        List<TaskSend> taskSends = taskSendDao.findTaskSendByTitleAndReEmpIdAndSeEmpId(empId, "%"+ title+"%", CommonUtil.getPageSize(), index);
        //System.out.println("s size:"+taskSends.size());
        for (TaskSend taskSend : taskSends) {
            List<TaskReceive> taskReceives = taskReceiveDao.findTaskReceivesByTaskSendId(taskSend.getTaskSendId());
            taskSend.setTaskReceives(taskReceives);
        }
        TaskSend_bo taskSend_bo = new TaskSend_bo();
        taskSend_bo.setTaskSends(taskSends);
        taskSend_bo.setTotal(total);
        taskSend_bo.setPage(page);
        taskSend_bo.setCount(CommonUtil.getPageSize());

        return taskSend_bo;
    }



}
