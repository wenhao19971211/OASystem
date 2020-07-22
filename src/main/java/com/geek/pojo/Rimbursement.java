package com.geek.pojo;

import java.util.Date;

/**
 * 报销发放
 */
public class Rimbursement {
    private Integer rimbursementIssue;
    private Reimbursement reimbursement;
    private double factMoney;
    private Date issueTime;
    private Emp emp;
    private Integer status;

    public Integer getRimbursementIssue() {
        return rimbursementIssue;
    }

    public void setRimbursementIssue(Integer rimbursementIssue) {
        this.rimbursementIssue = rimbursementIssue;
    }

    public Reimbursement getReimbursement() {
        return reimbursement;
    }

    public void setReimbursement(Reimbursement reimbursement) {
        this.reimbursement = reimbursement;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) {
        this.factMoney = factMoney;
    }

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
