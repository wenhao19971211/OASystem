package com.geek.pojo;

import java.util.Date;

/**
 * 报销发放
 */
public class Rimbursement {
    private Integer rimbursementIssue;
    private Integer rimbursementId;
    private double factMoney;
    private Date issueTime;
    private Integer empId;
    private Integer status;

    public Integer getRimbursementIssue() {
        return rimbursementIssue;
    }

    public void setRimbursementIssue(Integer rimbursementIssue) {
        this.rimbursementIssue = rimbursementIssue;
    }

    public Integer getRimbursementId() {
        return rimbursementId;
    }

    public void setRimbursementId(Integer rimbursementId) {
        this.rimbursementId = rimbursementId;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
