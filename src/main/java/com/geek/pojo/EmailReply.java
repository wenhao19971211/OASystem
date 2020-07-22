package com.geek.pojo;

import java.util.Date;

/**
 * 邮件回复
 */
public class EmailReply {
    private Integer emailReplyId;
    private Integer replyEmpId;
    private Date replyTime;
    private String replyContext;
    private Integer emailSendId;

    public Integer getEmailReplyId() {
        return emailReplyId;
    }

    public void setEmailReplyId(Integer emailReplyId) {
        this.emailReplyId = emailReplyId;
    }

    public Integer getReplyEmpId() {
        return replyEmpId;
    }

    public void setReplyEmpId(Integer replyEmpId) {
        this.replyEmpId = replyEmpId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyContext() {
        return replyContext;
    }

    public void setReplyContext(String replyContext) {
        this.replyContext = replyContext;
    }

    public Integer getEmailSendId() {
        return emailSendId;
    }

    public void setEmailSendId(Integer emailSendId) {
        this.emailSendId = emailSendId;
    }
}
