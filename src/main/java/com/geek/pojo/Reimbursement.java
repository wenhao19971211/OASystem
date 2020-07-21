package com.geek.pojo;

import java.util.Date;

/**
 * 报销
 */
public class Reimbursement {
    private Integer reimbursementId;
    private Integer applyEmpId;
    private Integer taskSendId;
    private Date sendTime;
    private double sum;
    private Integer checkEmpId;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Integer getApplyEmpId() {
        return applyEmpId;
    }

    public void setApplyEmpId(Integer applyEmpId) {
        this.applyEmpId = applyEmpId;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Integer getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(Integer checkEmpId) {
        this.checkEmpId = checkEmpId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}
