package com.geek.pojo;

import java.util.Date;

/**
 * 邮件发送
 */
public class EmailSend {
    private Integer emailSendId;
    private Integer sendEmpId;
    private Date sendTime;
    private String title;
    private String content;
    private Integer isDelete;

    public Integer getEmailSendId() {
        return emailSendId;
    }

    public void setEmailSendId(Integer emailSendId) {
        this.emailSendId = emailSendId;
    }

    public Integer getSendEmpId() {
        return sendEmpId;
    }

    public void setSendEmpId(Integer sendEmpId) {
        this.sendEmpId = sendEmpId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
