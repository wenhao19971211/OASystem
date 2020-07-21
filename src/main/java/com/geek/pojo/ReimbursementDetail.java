package com.geek.pojo;

/**
 * 报销明细
 */
public class ReimbursementDetail {
    private Integer reimbursementDetailId;
    private Integer type;
    private String detail;
    private double money;
    private Integer reimbursementId;

    public Integer getReimbursementDetailId() {
        return reimbursementDetailId;
    }

    public void setReimbursementDetailId(Integer reimbursementDetailId) {
        this.reimbursementDetailId = reimbursementDetailId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Integer getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(Integer reimbursementId) {
        this.reimbursementId = reimbursementId;
    }
}

