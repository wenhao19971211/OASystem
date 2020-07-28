package com.geek.pojo;

import java.util.Date;

/**
 * 考勤补录
 */
public class Collection {
    private Integer collectionId;
    private Emp emp;
    private Date today;
    private Date startTime;
    private Date endTime;
    private String collectionCause;
    private Date checkTime;
    private Integer checkStatus;


    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }


    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
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

    public String getCollectionCause() {
        return collectionCause;
    }

    public void setCollectionCause(String collectionCause) {
        this.collectionCause = collectionCause;
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
