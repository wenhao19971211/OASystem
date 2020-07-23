package com.geek.pojo;

import java.util.Date;
import java.util.List;

/**
 * 任务发起
 */
public class TaskSend {
    private Integer taskSendId;
    private int empId;
    private Date today;
    private String title;
    private String content;
    private Date startTime;
    private Date finishTime;
    private Integer status;
    private Emp emp;
    private List<TaskReceive> taskReceives;

    public TaskSend() {
    }

    public TaskSend(Integer taskSendId, int empId, Date today, String title, String content, Date startTime, Date finishTime, Integer status) {
        this.taskSendId = taskSendId;
        this.empId = empId;
        this.today = today;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
    }

    public TaskSend(Integer taskSendId, int empId, Date today, String title, String content, Date startTime, Date finishTime, Integer status, Emp emp) {
        this.taskSendId = taskSendId;
        this.empId = empId;
        this.today = today;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.emp = emp;
    }

    public TaskSend(Integer taskSendId, int empId, Date today, String title, String content, Date startTime, Date finishTime, Integer status, Emp emp, List<TaskReceive> taskReceives) {
        this.taskSendId = taskSendId;
        this.empId = empId;
        this.today = today;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.emp = emp;
        this.taskReceives = taskReceives;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    public List<TaskReceive> getTaskReceives() {
        return taskReceives;
    }

    public void setTaskReceives(List<TaskReceive> taskReceives) {
        this.taskReceives = taskReceives;
    }

    @Override
    public String toString() {
        return "TaskSend{" +
                "taskSendId=" + taskSendId +
                ", empId=" + empId +
                ", today=" + today +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", status=" + status ;
    }
}
