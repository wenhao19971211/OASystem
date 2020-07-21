package com.geek.pojo;

/**
 * 邮件接收
 */
public class EmailkReceive {
    private Integer emailkReceiveId;
    private Integer receiveEmpId;
    private Integer emailSendId;
    private Integer readStatus;
    private Integer isDelete;

    public Integer getEmailkReceiveId() {
        return emailkReceiveId;
    }

    public void setEmailkReceiveId(Integer emailkReceiveId) {
        this.emailkReceiveId = emailkReceiveId;
    }

    public Integer getReceiveEmpId() {
        return receiveEmpId;
    }

    public void setReceiveEmpId(Integer receiveEmpId) {
        this.receiveEmpId = receiveEmpId;
    }

    public Integer getEmailSendId() {
        return emailSendId;
    }

    public void setEmailSendId(Integer emailSendId) {
        this.emailSendId = emailSendId;
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
