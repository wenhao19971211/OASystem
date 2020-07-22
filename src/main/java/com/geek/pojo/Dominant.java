package com.geek.pojo;

/**
 * 员工可支配时间
 */
public class Dominant {
    private Emp emp;
    private Integer yaerLeaveSumTime;
    private Integer reYearLeaveTime;
    private Integer allowLeaveTime;
    private Integer reCollectionCount;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Integer getReYearLeaveTime() {
        return reYearLeaveTime;
    }

    public void setReYearLeaveTime(Integer reYearLeaveTime) {
        this.reYearLeaveTime = reYearLeaveTime;
    }

    public Integer getYaerLeaveSumTime() {
        return yaerLeaveSumTime;
    }

    public void setYaerLeaveSumTime(Integer yaerLeaveSumTime) {
        this.yaerLeaveSumTime = yaerLeaveSumTime;
    }

    public Integer getAllowLeaveTime() {
        return allowLeaveTime;
    }

    public void setAllowLeaveTime(Integer allowLeaveTime) {
        this.allowLeaveTime = allowLeaveTime;
    }

    public Integer getReCollectionCount() {
        return reCollectionCount;
    }

    public void setReCollectionCount(Integer reCollectionCount) {
        this.reCollectionCount = reCollectionCount;
    }
}
