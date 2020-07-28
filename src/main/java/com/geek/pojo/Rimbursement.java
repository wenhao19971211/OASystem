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
    private Emp emp;
    private Reimbursement reimbursement;

    public Rimbursement() {
    }

    public Rimbursement(Integer rimbursementIssue, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status) {
        this.rimbursementIssue = rimbursementIssue;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
    }

    public Rimbursement(Integer rimbursementIssue, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Emp emp) {
        this.rimbursementIssue = rimbursementIssue;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
    }

    public Rimbursement(Integer rimbursementIssue, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Reimbursement reimbursement) {
        this.rimbursementIssue = rimbursementIssue;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.reimbursement = reimbursement;
    }

    public Rimbursement(Integer rimbursementIssue, Integer rimbursementId, double factMoney, Date issueTime, Integer empId, Integer status, Emp emp, Reimbursement reimbursement) {
        this.rimbursementIssue = rimbursementIssue;
        this.rimbursementId = rimbursementId;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
        this.reimbursement = reimbursement;
    }



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
                "rimbursementIssue=" + rimbursementIssue +
                ", rimbursementId=" + rimbursementId +
                ", factMoney=" + factMoney +
                ", issueTime=" + issueTime +
                ", empId=" + empId +
                ", status=" + status +
                '}';
    }
}
