package com.geek.service;

import com.geek.bo.Message_bo;
import com.geek.bo.Messages_bo;
import com.geek.dao.MessageDao;
import com.geek.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Message> allById = messageDao.findAllById(empId, null, null);
        List<Message> messageList = messageDao.findAllById(empId, limit, limit * (page - 1));
        int size = allById.size();
        Message_bo message_bo = findMessage(messageList,size);
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
        List<Message> allById = messageDao.findNoExamineById(empId, null, null);
        List<Message> messageList = messageDao.findNoExamineById(empId,limit,limit*(page-1));
        int size = allById.size();
        return findMessage(messageList,size);
    }

    /**
     * 查询已审
     * @param empId
     * @return
     */
    public Message_bo findExamineById(int empId,Integer page,Integer limit){
        List<Message> allById = messageDao.findExamineById(empId, null, null);
        List<Message> messageList = messageDao.findExamineById(empId,limit,limit*(page-1));
        int size = allById.size();
        return findMessage(messageList,size);
    }

    /**
     * 查询待阅
     * @param empId
     * @return
     */
    public Message_bo findNoReadById(int empId,Integer page,Integer limit){
        List<Message> allById = messageDao.findNoReadById(empId, null, null);
        List<Message> messageList = messageDao.findNoReadById(empId,limit,limit*(page-1));
        int size = allById.size();
        return findMessage(messageList,size);
    }

    /**
     * 查询已阅
     * @param empId
     * @return
     */
    public Message_bo findReadById(int empId,Integer page,Integer limit){
        List<Message> allById = messageDao.findReadById(empId, null, null);
        List<Message> messageList = messageDao.findReadById(empId,limit,limit*(page-1));
        int size = allById.size();
        return findMessage(messageList,size);
    }

    /**
     * 封装消息
     * @param messageList
     * @param size
     * @return
     */
    public Message_bo findMessage(List<Message> messageList, int size){
        Message_bo message_bo = new Message_bo();
        List<Messages_bo> list = new ArrayList<>();
        for (Message message : messageList) {
            Messages_bo messages_bo = new Messages_bo();
            String type = "";
            String readStatus = "";
            if (message.getMessageType()== 1){
                type = "任务";
            }
            else if (message.getMessageType() == 2){
                type = "请假";
            }
            else if (message.getMessageType() == 3){
                type = "报销";
            }
            else if (message.getMessageType() == 4){
                type = "补录";
            }
            else if (message.getMessageType() == 5) {
                type = "加班";
            }
            else{
                type = "离职";
            }

            if (message.getReadStatus() ==1){
                readStatus = "待阅";
            }
            else{
                readStatus = "已阅";
            }
            messages_bo.setMessageType(type);
            messages_bo.setReadStatus(readStatus);
            messages_bo.setMessageContent(message.getMessageContent());
            messages_bo.setMessageId(message.getMessageId());
            list.add(messages_bo);
        }
        message_bo.setCount(size);
        message_bo.setMessages(list);
        return message_bo;
    }
}
