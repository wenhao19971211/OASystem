package com.geek.bo;

import com.geek.pojo.CheckWork;
import com.geek.pojo.WorkOn;

import java.util.Date;

public class CheckWork_bo {
    private Integer empId;
    private Date today;
    private Date workInTime;
    private Date workOutTime;
    private String isLate;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getWorkInTime() {
        return workInTime;
    }

    public void setWorkInTime(Date workInTime) {
        this.workInTime = workInTime;
    }

    public Date getWorkOutTime() {
        return workOutTime;
    }

    public void setWorkOutTime(Date workOutTime) {
        this.workOutTime = workOutTime;
    }

    public String getIsLate() {
        return isLate;
    }

    public void setIsLate(String isLate) {
        this.isLate = isLate;
    }
}
