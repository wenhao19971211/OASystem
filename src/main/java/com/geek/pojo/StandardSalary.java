package com.geek.pojo;

public class StandardSalary {

    private Integer StandardSalaryId;
    private Integer empId;
    private Double baseSalary;
    private Double perSalary;

    public StandardSalary() {
    }

    public StandardSalary(Integer standardSalaryId, Integer empId, Double baseSalary, Double perSalary) {
        StandardSalaryId = standardSalaryId;
        this.empId = empId;
        this.baseSalary = baseSalary;
        this.perSalary = perSalary;
    }

    public Integer getStandardSalaryId() {
        return StandardSalaryId;
    }

    public void setStandardSalaryId(Integer standardSalaryId) {
        StandardSalaryId = standardSalaryId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getPerSalary() {
        return perSalary;
    }

    public void setPerSalary(Double perSalary) {
        this.perSalary = perSalary;
    }
}
