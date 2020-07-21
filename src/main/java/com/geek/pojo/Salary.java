package com.geek.pojo;

import java.util.Date;

public class Salary {
    private Integer salaryId;
    private Integer empId;
    private Date month;
    private double baseSalary;
    private double perSalary;

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getPerSalary() {
        return perSalary;
    }

    public void setPerSalary(double perSalary) {
        this.perSalary = perSalary;
    }
}
