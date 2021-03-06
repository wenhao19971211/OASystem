package com.geek.pojo;

import java.util.Date;

/**
 * 消息
 */
public class Message {
    private Integer messageId;
    private Integer messageType;
    private Integer messageStatus;
    private Integer readStatus;
    private String messageContent;
    private Date sendTime;
    private Integer empId;
    private Emp emp;

    public Message() {
    }

    public Message(Integer messageId, Integer messageType, Integer messageStatus, Integer readStatus, String messageContent, Date sendTime, Integer empId) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.messageStatus = messageStatus;
        this.readStatus = readStatus;
        this.messageContent = messageContent;
        this.sendTime = sendTime;
        this.empId = empId;
    }

    public Message(Integer messageId, Integer messageType, Integer messageStatus, Integer readStatus, String messageContent, Date sendTime, Integer empId, Emp emp) {
        this.messageId = messageId;
        this.messageType = messageType;
        this.messageStatus = messageStatus;
        this.readStatus = readStatus;
        this.messageContent = messageContent;
        this.sendTime = sendTime;
        this.empId = empId;
        this.emp = emp;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
