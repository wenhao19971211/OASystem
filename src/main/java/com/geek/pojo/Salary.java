package com.geek.pojo;

import java.util.Date;

public class Salary {
    private Integer salaryId;
    private Integer empId;
    private Date month;
    private double baseSalary;
    private double perSalary;
    private Emp emp;

    public Salary() {
    }

    public Salary(Integer salaryId, Integer empId, Date month, double baseSalary, double perSalary) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.month = month;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
    }

    public Salary(Integer salaryId, Integer empId, Date month, double baseSalary, double perSalary, Emp emp) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.month = month;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
        this.emp = emp;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }
}
