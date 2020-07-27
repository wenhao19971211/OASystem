package com.geek.bo;

import com.geek.pojo.Rimbursement;

import java.util.List;

/**
 * 报销发放bo
 */
public class RimbursementIssue_bo {
    private Integer status;//发放状态
    private List<Rimbursement> rimbursements;//报销发放的当页数据
    private Integer count;//总共有多少条报销发放数据（该状态下）

    public RimbursementIssue_bo() {
    }

    public RimbursementIssue_bo(Integer status, List<Rimbursement> rimbursements, Integer count) {
        this.status = status;
        this.rimbursements = rimbursements;
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Rimbursement> getRimbursements() {
        return rimbursements;
    }

    public void setRimbursements(List<Rimbursement> rimbursements) {
        this.rimbursements = rimbursements;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
