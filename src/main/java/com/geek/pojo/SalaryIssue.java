package com.geek.pojo;

import java.util.Date;

/**
 * 薪资发放
 */
public class SalaryIssue {
    private Integer salaryIssueId;
    private Salary salary;
    private double issueMoney;
    private Date issueTime;
    private Emp emp;
    private Integer status;

    public Integer getSalaryIssueId() {
        return salaryIssueId;
    }

    public void setSalaryIssueId(Integer salaryIssueId) {
        this.salaryIssueId = salaryIssueId;
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

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
