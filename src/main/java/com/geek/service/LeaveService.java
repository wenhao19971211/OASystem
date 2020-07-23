package com.geek.service;

import com.geek.dao.*;
import com.geek.pojo.Dominant;
import com.geek.pojo.Message;
import com.geek.pojo.YearLeave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 请假相关
 */
@Service
public class LeaveService {
    @Autowired
    private DominantDao dominantDao;
    @Autowired
    private DayOffDao dayOffDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private YearLeaveDao yearLeaveDao;
    @Autowired
    private MessageDao messageDao;

    /**
     * 请假选择
     * @param leaveFlag 判断是哪种请假请求 1为调休 2为事假 3为年假
     * @param applyEmpId 发起人的id
     * @param content 请假的内容
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param empId 接受人id
     */
    @Transactional
    public void addLeave(int leaveFlag, int applyEmpId, String content, Date startTime,Date endTime, int empId){
        if (leaveFlag==1){
            //调休
            dayOffDao.addDayOff(applyEmpId,content,startTime,endTime,empId,null,1);
//            Dominant dominant=dominantDao.findDominantByEmpId(applyEmpId);
//            if (dominant.getAllowLeaveTime()>=8*days){
//            }
        }else if (leaveFlag==2){
            //事假
            leaveDao.addLeave(applyEmpId,content,startTime,endTime,empId,null,1);
        }else {
            //年假
            yearLeaveDao.addYearLeave(applyEmpId,content,startTime,endTime,empId,null,1);
        }
        //封装对象
        Message message=new Message();
        message.setMessageType(2);
        message.setMessageStatus(1);
        message.setReadStatus(1);
        message.setMessageContent(content);
        message.setSendTime(new Date());
        message.setEmpId(empId);
        //发送消息
        messageDao.addMessage(message);
    }


    /**
     * 通过员工id查找对应的可支配找时间
     * @param empId
     * @return
     */
    @Transactional
    public Dominant findDominantByEmpId(int empId){
        return dominantDao.findDominantByEmpId(empId);
    }

}
