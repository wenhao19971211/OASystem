package com.geek.pojo;

import java.util.Date;

/**
 * 任务接收
 */
public class TaskReceive {
    private Integer taskReceiveId;
    private Integer empId;
    private Integer taskSendId;
    private Date finishTime;
    private Integer status;
    private Emp emp;
    private TaskSend taskSend;
    public TaskReceive() {
    }

    public TaskReceive(Integer taskReceiveId, Integer empId, Integer taskSendId, Date finishTime, Integer status) {
        this.taskReceiveId = taskReceiveId;
        this.empId = empId;
        this.taskSendId = taskSendId;
        this.finishTime = finishTime;
        this.status = status;
    }

    public TaskReceive(Integer taskReceiveId, Integer empId, Integer taskSendId, Date finishTime, Integer status, Emp emp) {
        this.taskReceiveId = taskReceiveId;
        this.empId = empId;
        this.taskSendId = taskSendId;
        this.finishTime = finishTime;
        this.status = status;
        this.emp = emp;
    }

    public TaskReceive(Integer taskReceiveId, Integer empId, Integer taskSendId, Date finishTime, Integer status, Emp emp, TaskSend taskSend) {
        this.taskReceiveId = taskReceiveId;
        this.empId = empId;
        this.taskSendId = taskSendId;
        this.finishTime = finishTime;
        this.status = status;
        this.emp = emp;
        this.taskSend = taskSend;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
    }

    public Integer getTaskReceiveId() {
        return taskReceiveId;
    }

    public void setTaskReceiveId(Integer taskReceiveId) {
        this.taskReceiveId = taskReceiveId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public TaskSend getTaskSend() {
        return taskSend;
    }

    public void setTaskSend(TaskSend taskSend) {
        this.taskSend = taskSend;
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

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "TaskReceive{" +
                "taskReceiveId=" + taskReceiveId +
                ", empId=" + empId +
                ", taskSendId=" + taskSendId +
                ", finishTime=" + finishTime +
                ", status=" + status +
                '}';
    }
}
