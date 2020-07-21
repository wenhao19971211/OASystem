package com.geek.pojo;

import java.util.Date;

/**
 * 人事合同
 */
public class Contract {
    private Integer contractId;
    private Integer empId;
    private Integer contractType;
    private double salary;
    private Date effectTime;
    private Date failureTime;
    private Integer isTrainningContract;
    private Integer checkEmpId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
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

    public Integer getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(Integer checkEmpId) {
        this.checkEmpId = checkEmpId;
    }
}
