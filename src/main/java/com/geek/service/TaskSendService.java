package com.geek.service;

import com.geek.dao.TaskReceiveDao;
import com.geek.dao.TaskSendDao;
import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    private MessageService messageService;

    /**
     * 添加任务
     * @param title
     * @param content
     * @param startTime
     * @param finishTime
     * @param receiveEmpIds
     * @return
     */
    @Transactional
    public boolean addTaskSend(Integer sendEnpId,String title, String content, Date startTime,Date finishTime,Integer... receiveEmpIds)
    {
        //创建任务发起
        Date today = new Date();
        TaskSend taskSend = new TaskSend();
        taskSend.setEmpId(sendEnpId);
        taskSend.setToday(today);
        taskSend.setTitle(title);
        taskSend.setContent(content);
        taskSend.setStartTime(startTime);
        taskSend.setFinishTime(finishTime);
        taskSend.setStatus(1);
        //添加任务发起
        int count1 = taskSendDao.addTaskSend(taskSend);

        if(count1>0)
        {
            //查询任务发起信息
            TaskSend taskSend1 = taskSendDao.findTaskSenndByEmpIdAndToday(sendEnpId, today);
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
            int count4 = messageService.addMessage(1, null, 1, taskSend.getContent(), today, receiveEmpId);

            if (count3 < 1 || count4 <1)
            {
                count2 = 0;
            }
        }



        return count1>0&&count2>0;
    }




}
