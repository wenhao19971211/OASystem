package com.geek.pojo;

/**
 * 邮件接收
 */
public class EmailkReceive {
    private Integer emailkReceiveId;
    private Emp emp;
    private EmailSend emailSend;
    private Integer readStatus;
    private Integer isDelete;

    public Integer getEmailkReceiveId() {
        return emailkReceiveId;
    }

    public void setEmailkReceiveId(Integer emailkReceiveId) {
        this.emailkReceiveId = emailkReceiveId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public EmailSend getEmailSend() {
        return emailSend;
    }

    public void setEmailSend(EmailSend emailSend) {
        this.emailSend = emailSend;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
