package com.geek.bo;

/**
 * 薪资发放详情
 */
public class SalaryIssue_detail_bo {

    private Integer salaryIssueId;
    private String salaryReceiveEmpName;//接收人名称
    private String salaryReceiveDepName;//接收人部门
    private double issueMoney;//发放金额
    private String issueTime;//发放时间
    private String status;//发放状态
    private String issueEmpName;//发放人的名称

    public SalaryIssue_detail_bo() {
    }

    public SalaryIssue_detail_bo(Integer salaryIssueId, String salaryReceiveEmpName, String salaryReceiveDepName, double issueMoney, String issueTime, String status) {
        this.salaryIssueId = salaryIssueId;
        this.salaryReceiveEmpName = salaryReceiveEmpName;
        this.salaryReceiveDepName = salaryReceiveDepName;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.status = status;
    }

    public SalaryIssue_detail_bo(Integer salaryIssueId, String salaryReceiveEmpName, String salaryReceiveDepName, double issueMoney, String issueTime, String status, String issueEmpName) {
        this.salaryIssueId = salaryIssueId;
        this.salaryReceiveEmpName = salaryReceiveEmpName;
        this.salaryReceiveDepName = salaryReceiveDepName;
        this.issueMoney = issueMoney;
        this.issueTime = issueTime;
        this.status = status;
        this.issueEmpName = issueEmpName;
    }

    public Integer getSalaryIssueId() {
        return salaryIssueId;
    }

    public void setSalaryIssueId(Integer salaryIssueId) {
        this.salaryIssueId = salaryIssueId;
    }

    public String getSalaryReceiveEmpName() {
        return salaryReceiveEmpName;
    }

    public void setSalaryReceiveEmpName(String salaryReceiveEmpName) {
        this.salaryReceiveEmpName = salaryReceiveEmpName;
    }

    public String getSalaryReceiveDepName() {
        return salaryReceiveDepName;
    }

    public void setSalaryReceiveDepName(String salaryReceiveDepName) {
        this.salaryReceiveDepName = salaryReceiveDepName;
    }

    public double getIssueMoney() {
        return issueMoney;
    }

    public void setIssueMoney(double issueMoney) {
        this.issueMoney = issueMoney;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIssueEmpName() {
        return issueEmpName;
    }

    public void setIssueEmpName(String issueEmpName) {
        this.issueEmpName = issueEmpName;
    }
}
