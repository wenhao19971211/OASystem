package com.geek.pojo;

import java.util.Date;

public class Departure {
    private Integer empId;
    private Integer depId;
    private String position;
    private Date departureTime;
    private String reason;
    private Integer checkEmpId;
    private Date handleTime;

    public Departure() {
    }

    public Departure(Integer empId, Integer depId, String position, Date departureTime, String reason, Integer checkEmpId) {
        this.empId = empId;
        this.depId = depId;
        this.position = position;
        this.departureTime = departureTime;
        this.reason = reason;
        this.checkEmpId = checkEmpId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(Integer checkEmpId) {
        this.checkEmpId = checkEmpId;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }
}
