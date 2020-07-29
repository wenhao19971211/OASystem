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
    private Emp emp;//申请人
    private Dep dep;//申请人所在部门
    private Emp checkEmp;//审核人
    private TaskSend taskSend;
    public Reimbursement() {
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp, Dep dep) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
        this.dep = dep;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp, Emp checkEmp) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
        this.checkEmp = checkEmp;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp, Emp checkEmp, TaskSend taskSend) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
        this.checkEmp = checkEmp;
        this.taskSend = taskSend;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp, Dep dep, Emp checkEmp, TaskSend taskSend) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
        this.dep = dep;
        this.checkEmp = checkEmp;
        this.taskSend = taskSend;
    }

    public Reimbursement(Integer reimbursementId, Integer applyEmpId, Integer taskSendId, Date sendTime, double sum, Integer checkEmpId, Date checkTime, Integer checkStatus, Emp emp, Dep dep, Emp checkEmp) {
        this.reimbursementId = reimbursementId;
        this.applyEmpId = applyEmpId;
        this.taskSendId = taskSendId;
        this.sendTime = sendTime;
        this.sum = sum;
        this.checkEmpId = checkEmpId;
        this.checkTime = checkTime;
        this.checkStatus = checkStatus;
        this.emp = emp;
        this.dep = dep;
        this.checkEmp = checkEmp;
    }

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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Emp getCheckEmp() {
        return checkEmp;
    }

    public void setCheckEmp(Emp checkEmp) {
        this.checkEmp = checkEmp;
    }

    public TaskSend getTaskSend() {
        return taskSend;
    }

    public void setTaskSend(TaskSend taskSend) {
        this.taskSend = taskSend;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", applyEmpId=" + applyEmpId +
                ", taskSendId=" + taskSendId +
                ", sendTime=" + sendTime +
                ", sum=" + sum +
                ", checkEmpId=" + checkEmpId +
                ", checkTime=" + checkTime +
                ", checkStatus=" + checkStatus +
                '}';
    }
}
