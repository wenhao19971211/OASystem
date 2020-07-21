package com.geek.pojo;

import java.util.Date;

/**
 * 事假
 */
public class LeaveId {
    private Integer leaveId;
    private Integer applyEmpId;
    private String leaveCause;
    private Date sendTime;
    private Date startTime;
    private Date endTime;
    private Integer checkEmpId;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getApplyEmpId() {
        return applyEmpId;
    }

    public void setApplyEmpId(Integer applyEmpId) {
        this.applyEmpId = applyEmpId;
    }

    public String getLeaveCause() {
        return leaveCause;
    }

    public void setLeaveCause(String leaveCause) {
        this.leaveCause = leaveCause;
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
