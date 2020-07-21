package com.geek.pojo;

import java.util.Date;

/**
 * 奖惩
 */
public class ReAndPu {
    private Integer rewardAndPuishId;
    private Integer empId;
    private Integer type;
    private double money;
    private String cause;
    private Integer item;
    private Date reAndPuTime;

    public Integer getRewardAndPuishId() {
        return rewardAndPuishId;
    }

    public void setRewardAndPuishId(Integer rewardAndPuishId) {
        this.rewardAndPuishId = rewardAndPuishId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Date getReAndPuTime() {
        return reAndPuTime;
    }

    public void setReAndPuTime(Date reAndPuTime) {
        this.reAndPuTime = reAndPuTime;
    }
}
