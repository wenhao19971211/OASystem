package com.geek.bo;

import com.geek.pojo.SalaryIssue;

import java.util.List;

public class SalaryIssue_bo {
    private Integer status;//薪水发放状态
    private List<SalaryIssue> salaryIssues;//当页的薪水发放数据
    private Integer count;//总共有多少条数据

    public SalaryIssue_bo() {
    }

    public SalaryIssue_bo(Integer status, List<SalaryIssue> salaryIssues, Integer count) {
        this.status = status;
        this.salaryIssues = salaryIssues;
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SalaryIssue> getSalaryIssues() {
        return salaryIssues;
    }

    public void setSalaryIssues(List<SalaryIssue> salaryIssues) {
        this.salaryIssues = salaryIssues;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
