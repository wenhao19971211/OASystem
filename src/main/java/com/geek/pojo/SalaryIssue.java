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
    private Emp emp;
    private Salary salary;

    public SalaryIssue() {
    }

    public SalaryIssue(Integer salaryIssueId, Integer salaryId, double issueMoney, Date issueTime, Integer empId, Integer status) {
        this.salaryIssueId = salaryIssueId;
        this.salaryId = salaryId;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
    }

    public SalaryIssue(Integer salaryIssueId, Salary salary, double issueMoney, Date issueTime, Integer empId, Integer status, Emp emp) {
        this.salaryIssueId = salaryIssueId;
        this.salary = salary;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
    }

    public SalaryIssue(Integer salaryIssueId, Integer salaryId, double issueMoney, Date issueTime, Integer empId, Integer status, Salary salary) {
        this.salaryIssueId = salaryIssueId;
        this.salaryId = salaryId;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.salary = salary;
    }

    public SalaryIssue(Integer salaryIssueId, Integer salaryId, double issueMoney, Date issueTime, Integer empId, Integer status, Emp emp, Salary salary) {
        this.salaryIssueId = salaryIssueId;
        this.salaryId = salaryId;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.empId = empId;
        this.status = status;
        this.emp = emp;
        this.salary = salary;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
