package com.geek.pojo;

import java.util.Date;

/**
 * 年假
 */
public class YearLeave {
    private Integer yearLeaveId;
    private Emp emp;
    private String yearLeaveCause;
    private Date sendTime;
    private Date startTime;
    private Date endTime;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getYearLeaveId() {
        return yearLeaveId;
    }

    public void setYearLeaveId(Integer yearLeaveId) {
        this.yearLeaveId = yearLeaveId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getYearLeaveCause() {
        return yearLeaveCause;
    }

    public void setYearLeaveCause(String yearLeaveCause) {
        this.yearLeaveCause = yearLeaveCause;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}
