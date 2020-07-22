package com.geek.pojo;

import java.util.Date;

/**
 * 人事合同
 */
public class Contract {
    private Integer contractId;
    private Emp emp;
    private Integer contractType;
    private double salary;
    private Date effectTime;
    private Date failureTime;
    private Integer isTrainningContract;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }



    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }

    public Integer getIsTrainningContract() {
        return isTrainningContract;
    }

    public void setIsTrainningContract(Integer isTrainningContract) {
        this.isTrainningContract = isTrainningContract;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }
}
