package com.geek.pojo;

import java.util.Date;

/**
 * 任务接收
 */
public class TaskReceive {
    private Integer taskReceive;
    private Integer empId;
    private Integer taskSendId;
    private Date finishTime;
    private Integer status;

    public Integer getTaskReceive() {
        return taskReceive;
    }

    public void setTaskReceive(Integer taskReceive) {
        this.taskReceive = taskReceive;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
