package com.geek.bo;

import com.geek.pojo.Salary;

import java.util.List;

public class Salary_bo {
    private Integer empId;
    private List<Salary> salaries;//当页显示的数据
    private Integer count;//总共有多少条数据

    public Salary_bo() {
    }

    public Salary_bo(Integer empId, List<Salary> salaries, Integer count) {
        this.empId = empId;
        this.salaries = salaries;
        this.count = count;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public List<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(List<Salary> salaries) {
        this.salaries = salaries;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
