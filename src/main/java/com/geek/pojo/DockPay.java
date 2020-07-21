package com.geek.pojo;

import java.util.Date;

/**
 * 扣薪
 */
public class DockPay {
    private Integer empId;
    private Date dockPayDay;
    private Integer dockPayType;
    private double dockPayMoney;
    private String dockPayTime;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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
