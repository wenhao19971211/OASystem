package com.geek.pojo;

import java.util.Date;

/**
 * 薪资发放
 */
public class SalaryIssue {
    private Integer salaryIssueId;
    private Integer salaryId;
    private double issueMoney;
    private Date issueTime;
    private Integer empId;
    private Integer status;

    public Integer getSalaryIssueId() {
        return salaryIssueId;
    }

    public void setSalaryIssueId(Integer salaryIssueId) {
        this.salaryIssueId = salaryIssueId;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public double getIssueMoney() {
        return issueMoney;
    }

    public void setIssueMoney(double issueMoney) {
        this.issueMoney = issueMoney;
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
