package com.geek.pojo;

import java.util.Date;

/**
 * 任务接收
 */
public class TaskReceive {
    private Integer taskReceiveId;
    private Emp emp;
    private TaskSend taskSend;
    private Date finishTime;
    private Integer status;

    public Integer getTaskReceiveId() {
        return taskReceiveId;
    }

    public void setTaskReceiveId(Integer taskReceiveId) {
        this.taskReceiveId = taskReceiveId;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
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
}
