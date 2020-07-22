package com.geek.pojo;

import java.util.Date;

/**
 * 报销
 */
public class Reimbursement {
    private Integer reimbursementId;
    private Emp emp;
    private TaskSend taskSend;
    private Date sendTime;
    private double sum;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public TaskSend getTaskSend() {
        return taskSend;
    }

    public void setTaskSend(TaskSend taskSend) {
        this.taskSend = taskSend;
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
