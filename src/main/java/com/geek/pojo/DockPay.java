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
    private Emp emp;

    public DockPay() {
    }

    public DockPay(Integer empId, Date dockPayDay, Integer dockPayType, double dockPayMoney, String dockPayTime) {
        this.empId = empId;
        this.dockPayDay = dockPayDay;
        this.dockPayType = dockPayType;
        this.dockPayMoney = dockPayMoney;
        this.dockPayTime = dockPayTime;
    }

    public DockPay(Integer empId, Date dockPayDay, Integer dockPayType, double dockPayMoney, String dockPayTime, Emp emp) {
        this.empId = empId;
        this.dockPayDay = dockPayDay;
        this.dockPayType = dockPayType;
        this.dockPayMoney = dockPayMoney;
        this.dockPayTime = dockPayTime;
        this.emp = emp;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

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
