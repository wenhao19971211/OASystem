package com.geek.bo;

import com.geek.pojo.Emp;

import java.util.Date;

public class Salary_detail_bo {

    private Integer salaryId;
    private Integer empId;
    private String month;
    private double baseSalary;
    private double perSalary;
    private double absenteeismMoney;//旷工扣薪
    private double leaveMoney;//事假扣薪
    private double lateArrivalMoney;//迟到早退扣薪
    private double socialSecurityMoney;//社保
    private double individualIncomeTax;//个人所得税
    private Emp emp;

    public Salary_detail_bo() {
    }

    public Salary_detail_bo(Integer salaryId, Integer empId, String month, double baseSalary, double perSalary) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.month = month;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
    }

    public Salary_detail_bo(Integer salaryId, Integer empId, String month, double baseSalary, double perSalary, double absenteeismMoney, double leaveMoney, double lateArrivalMoney, double socialSecurityMoney, double individualIncomeTax) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.month = month;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
        this.absenteeismMoney = absenteeismMoney;
        this.leaveMoney = leaveMoney;
        this.lateArrivalMoney = lateArrivalMoney;
        this.socialSecurityMoney = socialSecurityMoney;
        this.individualIncomeTax = individualIncomeTax;
    }

    public Salary_detail_bo(Integer salaryId, Integer empId, String month, double baseSalary, double perSalary, double absenteeismMoney, double leaveMoney, double lateArrivalMoney, double socialSecurityMoney, double individualIncomeTax, Emp emp) {
        this.salaryId = salaryId;
        this.empId = empId;
        this.month = month;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
        this.absenteeismMoney = absenteeismMoney;
        this.leaveMoney = leaveMoney;
        this.lateArrivalMoney = lateArrivalMoney;
        this.socialSecurityMoney = socialSecurityMoney;
        this.individualIncomeTax = individualIncomeTax;
        this.emp = emp;
    }

    public Salary_detail_bo(Integer salaryId, Integer empId, String month, double baseSalary, double perSalary, Emp emp) {
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
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

    public double getAbsenteeismMoney() {
        return absenteeismMoney;
    }

    public void setAbsenteeismMoney(double absenteeismMoney) {
        this.absenteeismMoney = absenteeismMoney;
    }

    public double getLeaveMoney() {
        return leaveMoney;
    }

    public void setLeaveMoney(double leaveMoney) {
        this.leaveMoney = leaveMoney;
    }

    public double getLateArrivalMoney() {
        return lateArrivalMoney;
    }

    public void setLateArrivalMoney(double lateArrivalMoney) {
        this.lateArrivalMoney = lateArrivalMoney;
    }

    public double getSocialSecurityMoney() {
        return socialSecurityMoney;
    }

    public void setSocialSecurityMoney(double socialSecurityMoney) {
        this.socialSecurityMoney = socialSecurityMoney;
    }

    public double getIndividualIncomeTax() {
        return individualIncomeTax;
    }

    public void setIndividualIncomeTax(double individualIncomeTax) {
        this.individualIncomeTax = individualIncomeTax;
    }
}
