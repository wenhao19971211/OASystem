package com.geek.pojo;

import java.util.Date;

public class CheckWork {
    private Emp emp;
    private Date today;
    private String isLate;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getIsLate() {
        return isLate;
    }

    public void setIsLate(String isLate) {
        this.isLate = isLate;
    }
}
