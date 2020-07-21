package com.geek.pojo;

import java.util.Date;

/**
 * 年假
 */
public class YearLeave {
    private Integer yearLeaveId;
    private Integer applyEmpId;
    private String yearLeaveCause;
    private Date sendTime;
    private Date startTime;
    private Date endTime;
    private Integer checkEmpId;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getYearLeaveId() {
        return yearLeaveId;
    }

    public void setYearLeaveId(Integer yearLeaveId) {
        this.yearLeaveId = yearLeaveId;
    }

    public Integer getApplyEmpId() {
        return applyEmpId;
    }

    public void setApplyEmpId(Integer applyEmpId) {
        this.applyEmpId = applyEmpId;
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

    public Integer getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(Integer checkEmpId) {
        this.checkEmpId = checkEmpId;
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
