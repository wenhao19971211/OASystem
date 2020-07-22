package com.geek.pojo;

import java.util.Date;

/**
 * 调休
 */
public class DayOff {
    private Integer dayOffId;
    private Emp emp;
    private String dayOffCause;
    private Date sendTime;
    private Date startTime;
    private Date endTime;
    private Date checkTime;
    private Integer checkStatus;

    public Integer getDayOffId() {
        return dayOffId;
    }

    public void setDayOffId(Integer dayOffId) {
        this.dayOffId = dayOffId;
    }



    public String getDayOffCause() {
        return dayOffCause;
    }

    public void setDayOffCause(String dayOffCause) {
        this.dayOffCause = dayOffCause;
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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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
