package com.geek.service;

import com.geek.bo.Message_bo;
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
    public Message_bo findAllById(int empId, Integer page, Integer limit){
        Message_bo message_bo = new Message_bo();
        List<Message> allById = messageDao.findAllById(empId, null, null);

        List<Message> allById1 = messageDao.findAllById(empId, limit, limit * (page - 1));

        message_bo.setCount(allById.size());
        message_bo.setMessages(allById1);
        return message_bo;
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
    public Message_bo findNoExamineById(int empId,Integer page,Integer limit){
        Message_bo message_bo = new Message_bo();
        List<Message> allById = messageDao.findNoExamineById(empId, null, null);

        List<Message> allById1 = messageDao.findNoExamineById(empId,limit,limit*(page-1));

        message_bo.setCount(allById.size());
        message_bo.setMessages(allById1);
        return message_bo;
    }

    /**
     * 查询已审
     * @param empId
     * @return
     */
    public Message_bo findExamineById(int empId,Integer page,Integer limit){

        Message_bo message_bo = new Message_bo();
        List<Message> allById = messageDao.findExamineById(empId, null, null);

        List<Message> allById1 = messageDao.findExamineById(empId,limit,limit*(page-1));

        message_bo.setCount(allById.size());
        message_bo.setMessages(allById1);
        return message_bo;
    }

    /**
     * 查询待阅
     * @param empId
     * @return
     */
    public Message_bo findNoReadById(int empId,Integer page,Integer limit){

        Message_bo message_bo = new Message_bo();
        List<Message> allById = messageDao.findNoReadById(empId, null, null);

        List<Message> allById1 = messageDao.findNoReadById(empId,limit,limit*(page-1));

        message_bo.setCount(allById.size());
        message_bo.setMessages(allById1);
        return message_bo;
    }

    /**
     * 查询已阅
     * @param empId
     * @return
     */
    public Message_bo findReadById(int empId,Integer page,Integer limit){
        Message_bo message_bo = new Message_bo();
        List<Message> allById = messageDao.findReadById(empId, null, null);

        List<Message> allById1 = messageDao.findReadById(empId,limit,limit*(page-1));

        message_bo.setCount(allById.size());
        message_bo.setMessages(allById1);
        return message_bo;
    }
}
