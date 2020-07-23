package com.geek.service;

import com.geek.dao.MessageDao;
import com.geek.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    /**
     * 根据员工编号查询所有消息
     * 查询所有信息
     * @param empId
     * @return
     */
    public List<Message> findAllById(int empId){
        return messageDao.findAllById(empId);
    }

    /**
     * 添加新的消息提醒
     * @param messageType
     * @param messageStatus
     * @param readStatus
     * @param messageContent
     * @param sendTime
     * @param empId
     * @return
     */
    public boolean addMessage(Integer messageType, Integer messageStatus, Integer readStatus, String messageContent, Date sendTime,Integer empId)
    {
        Message message = new Message();
        message.setMessageType(messageType);
        message.setMessageStatus(messageStatus);
        message.setReadStatus(readStatus);
        message.setMessageContent(messageContent);
        message.setSendTime(sendTime);
        message.setEmpId(empId);
        int count = messageDao.addMessage(message);
        return count>0;
    }

    /**
     * 查询待审
     * @param empId
     * @return
     */
    public List<Message> findNoExamineById(int empId){
        return messageDao.findNoExamineById(empId);
    }

    /**
     * 查询已审
     * @param empId
     * @return
     */
    public List<Message> findExamineById(int empId){
        return messageDao.findExamineById(empId);
    }

    /**
     * 查询待阅
     * @param empId
     * @return
     */
    public List<Message> findNoReadById(int empId){
        return messageDao.findNoReadById(empId);
    }

    /**
     * 查询已阅
     * @param empId
     * @return
     */
    public List<Message> findReadById(int empId){
        return messageDao.findReadById(empId);
    }
}
