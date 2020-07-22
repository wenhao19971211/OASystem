package com.geek.pojo;

import java.util.Date;

/**
 * 工作日志
 */
public class WorkLog {
    private Integer logId;
    private Emp emp;
    private String content;
    private Date writLogTime;
    private Date checkTime;
    private Integer checkStatus;
    private Date thatDay;

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWritLogTime() {
        return writLogTime;
    }

    public void setWritLogTime(Date writLogTime) {
        this.writLogTime = writLogTime;
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

    public Date getThatDay() {
        return thatDay;
    }

    public void setThatDay(Date thatDay) {
        this.thatDay = thatDay;
    }
}
