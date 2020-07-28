package com.geek.bo;

public class RimbursementIssue_detail_bo {
    private Integer rimbursementIssueId;
    private String applyEmpName;
    private String applyDepName;
    private double sum;//报销金额
    private double factMoney;//实际报销金额
    private String issueTime;//发放时间
    private String issueStatus;//是否发放

    public RimbursementIssue_detail_bo() {
    }

    public RimbursementIssue_detail_bo(Integer rimbursementIssueId, String applyEmpName, String applyDepName, double sum, double factMoney, String issueTime) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.applyEmpName = applyEmpName;
        this.applyDepName = applyDepName;
        this.sum = sum;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
    }

    public RimbursementIssue_detail_bo(Integer rimbursementIssueId, String applyEmpName, String applyDepName, double sum, double factMoney, String issueTime, String issueStatus) {
        this.rimbursementIssueId = rimbursementIssueId;
        this.applyEmpName = applyEmpName;
        this.applyDepName = applyDepName;
        this.sum = sum;
        this.factMoney = factMoney;
        this.issueTime = issueTime;
        this.issueStatus = issueStatus;
    }

    public Integer getRimbursementIssueId() {
        return rimbursementIssueId;
    }

    public void setRimbursementIssueId(Integer rimbursementIssueId) {
        this.rimbursementIssueId = rimbursementIssueId;
    }

    public String getApplyEmpName() {
        return applyEmpName;
    }

    public void setApplyEmpName(String applyEmpName) {
        this.applyEmpName = applyEmpName;
    }

    public String getApplyDepName() {
        return applyDepName;
    }

    public void setApplyDepName(String applyDepName) {
        this.applyDepName = applyDepName;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getFactMoney() {
        return factMoney;
    }

    public void setFactMoney(double factMoney) {
        this.factMoney = factMoney;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }
}
