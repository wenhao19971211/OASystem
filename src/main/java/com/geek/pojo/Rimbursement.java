package com.geek.pojo;

import java.util.Date;

/**
 * 报销发放
 */
public class Rimbursement {
    private Integer rimbursementIssueId;
    private Integer rimbursementId;
    private double factMoney;
    private Date issueTime;
    private Integer empId;
    private Integer status;
    private Emp emp;
    private Reimbursement reimbursement;

    public Rimbursement() {
    }

    public Rimbursement(Integer rimbursementIssueId, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
    }

    public Rimbursement(Integer rimbursementIssueId, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Emp emp) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
    }

    public Rimbursement(Integer rimbursementIssueId, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Reimbursement reimbursement) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.reimbursement = reimbursement;
    }

    public Rimbursement(Integer rimbursementIssueId, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Emp emp, Reimbursement reimbursement) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
        this.reimbursement = reimbursement;
    }



    public Integer getRimbursementIssue() {
        return rimbursementIssueId;
    }

    public void setRimbursementIssue(Integer rimbursementIssueId) {
        this.rimbursementIssueId = rimbursementIssueId;
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

    public Integer getRimbursementId() {
        return rimbursementId;
    }

    public void setRimbursementId(Integer rimbursementId) {
        this.rimbursementId = rimbursementId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Rimbursement{" +
                "rimbursementIssueId=" + rimbursementIssueId +
                ", rimbursementId=" + rimbursementId +
                ", factMoney=" + factMoney +
                ", issueTime=" + issueTime +
                ", empId=" + empId +
                ", status=" + status +
                '}';
    }
}
