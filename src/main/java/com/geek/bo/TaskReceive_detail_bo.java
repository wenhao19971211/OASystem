package com.geek.bo;

import java.util.Date;

/**
 * 接收任务
 */
public class TaskReceive_detail_bo {
    private Integer taskSendId;
    private String taskSendEmpName;//任务发布人
    private String title;//任务标题
    private String content;//任务内容
    private String startTime;//任务开始时间
    private String finishTime;//任务完预计成时间
    private String factFinishTime;//任务完成时间
    private String status;//任务完成状态
    private Integer taskReceiveId;//任务接收编号


    public TaskReceive_detail_bo() {
    }

    public TaskReceive_detail_bo(Integer taskSendId, String taskSendEmpName, String title, String content, String startTime, String finishTime, String factFinishTime, String status) {
        this.taskSendId = taskSendId;
        this.taskSendEmpName = taskSendEmpName;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.factFinishTime = factFinishTime;
        this.status = status;

    }

    public TaskReceive_detail_bo(Integer taskSendId, String taskSendEmpName, String title, String content, String startTime, String finishTime, String factFinishTime, String status, Integer taskReceiveId) {
        this.taskSendId = taskSendId;
        this.taskSendEmpName = taskSendEmpName;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.factFinishTime = factFinishTime;
        this.status = status;
        this.taskReceiveId = taskReceiveId;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
    }

    public String getTaskSendEmpName() {
        return taskSendEmpName;
    }

    public void setTaskSendEmpName(String taskSendEmpName) {
        this.taskSendEmpName = taskSendEmpName;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getFactFinishTime() {
        return factFinishTime;
    }

    public void setFactFinishTime(String factFinishTime) {
        this.factFinishTime = factFinishTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTaskReceiveId() {
        return taskReceiveId;
    }

    public void setTaskReceiveId(Integer taskReceiveId) {
        this.taskReceiveId = taskReceiveId;
    }
}
