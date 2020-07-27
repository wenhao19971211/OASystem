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
    private Emp checkEmp;

    public Emp getCheckEmp() {
        return checkEmp;
    }

    public void setCheckEmp(Emp checkEmp) {
        this.checkEmp = checkEmp;
    }

    private Emp emp;

    public Contract() {
    }

    public Contract(Integer contractId, Integer empId, Integer contractType, double salary, Date effectTime, Date failureTime, Integer isTrainningContract) {
        this.contractId = contractId;
        this.empId = empId;
        this.contractType = contractType;
        this.salary = salary;
        this.effectTime = effectTime;
        this.failureTime = failureTime;
        this.isTrainningContract = isTrainningContract;
    }

    public Contract(Integer contractId, Integer empId, Integer contractType, double salary, Date effectTime, Date failureTime, Integer isTrainningContract, Emp emp) {
        this.contractId = contractId;
        this.empId = empId;
        this.contractType = contractType;
        this.salary = salary;
        this.effectTime = effectTime;
        this.failureTime = failureTime;
        this.isTrainningContract = isTrainningContract;
        this.emp = emp;
    }

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

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", empId=" + empId +
                ", contractType=" + contractType +
                ", salary=" + salary +
                ", effectTime=" + effectTime +
                ", failureTime=" + failureTime +
                ", isTrainningContract=" + isTrainningContract +
                '}';
    }
}
