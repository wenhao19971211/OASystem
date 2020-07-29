package com.geek.bo;

public class Prize_bo {
    private String company;
    private String type;
    private String item;
    private String reAndPuTime;
    private double money;
    private String cause;

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getReAndPuTime() {
        return reAndPuTime;
    }

    public void setReAndPuTime(String reAndPuTime) {
        this.reAndPuTime = reAndPuTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
