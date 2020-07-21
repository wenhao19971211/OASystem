package com.geek.pojo;

import java.util.Date;

/**
 * 上班打卡
 */
public class WorkOn {
    private Integer empId;
    private Date today;
    private Date workInTime;
    private Date workOutTime;

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
}
