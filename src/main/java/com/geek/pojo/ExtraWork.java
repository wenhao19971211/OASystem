package com.geek.pojo;

import java.util.Date;

/**
 * 加班
 */
public class ExtraWork {
    private Integer extraWorkId;
    private Emp emp;
    private Date sendTime;
    private Date startTime;
    private Date endTime;
    private String extraWorkCause;
    private Integer checkStatus;
    private Date checkTime;
    private Integer extraWorkTime;

    public Integer getExtraWorkId() {
        return extraWorkId;
    }

    public void setExtraWorkId(Integer extraWorkId) {
        this.extraWorkId = extraWorkId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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

    public String getExtraWorkCause() {
        return extraWorkCause;
    }

    public void setExtraWorkCause(String extraWorkCause) {
        this.extraWorkCause = extraWorkCause;
    }


    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getExtraWorkTime() {
        return extraWorkTime;
    }

    public void setExtraWorkTime(Integer extraWorkTime) {
        this.extraWorkTime = extraWorkTime;
    }
}
