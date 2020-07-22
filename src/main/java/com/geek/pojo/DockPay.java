package com.geek.pojo;

import java.util.Date;

/**
 * 扣薪
 */
public class DockPay {
    private Emp emp;
    private Date dockPayDay;
    private Integer dockPayType;
    private double dockPayMoney;
    private String dockPayTime;

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public Date getDockPayDay() {
        return dockPayDay;
    }

    public void setDockPayDay(Date dockPayDay) {
        this.dockPayDay = dockPayDay;
    }

    public Integer getDockPayType() {
        return dockPayType;
    }

    public void setDockPayType(Integer dockPayType) {
        this.dockPayType = dockPayType;
    }

    public double getDockPayMoney() {
        return dockPayMoney;
    }

    public void setDockPayMoney(double dockPayMoney) {
        this.dockPayMoney = dockPayMoney;
    }

    public String getDockPayTime() {
        return dockPayTime;
    }

    public void setDockPayTime(String dockPayTime) {
        this.dockPayTime = dockPayTime;
    }
}
