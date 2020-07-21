package com.geek.pojo;

/**
 * 员工可支配时间
 */
public class Dominant {
    private Integer empId;
    private Integer yaerLeaveSumTime;
    private Integer allowLeaveTime;
    private Integer reCollectionCount;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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
