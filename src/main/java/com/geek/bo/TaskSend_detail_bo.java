package com.geek.bo;

/**
 * 任务发送详情
 */
public class TaskSend_detail_bo {

    private Integer taskSendId;//任务发表id
    private String taskSendEmpName;//任务发布人
    private String title;//任务标题
    private String content;//任务内容
    private String startTime;//任务开始时间
    private String finishTime;//任务完预计成时间
    private String status;//任务完成状态
    private String taskReceiveEmpName;//任务接收人，多人以“，”拼接

    public TaskSend_detail_bo() {
    }

    public TaskSend_detail_bo(Integer taskSendId, String title, String content, String startTime, String finishTime, String status, String taskReceiveEmpName) {
        this.taskSendId = taskSendId;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.taskReceiveEmpName = taskReceiveEmpName;
    }

    public TaskSend_detail_bo(Integer taskSendId, String taskSendEmpName, String title, String content, String startTime, String finishTime, String status, String taskReceiveEmpName) {
        this.taskSendId = taskSendId;
        this.taskSendEmpName = taskSendEmpName;
        this.title = title;
        this.content = content;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.status = status;
        this.taskReceiveEmpName = taskReceiveEmpName;
    }

    public Integer getTaskSendId() {
        return taskSendId;
    }

    public void setTaskSendId(Integer taskSendId) {
        this.taskSendId = taskSendId;
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



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskReceiveEmpName() {
        return taskReceiveEmpName;
    }

    public void setTaskReceiveEmpName(String taskReceiveEmpName) {
        this.taskReceiveEmpName = taskReceiveEmpName;
    }

    public String getTaskSendEmpName() {
        return taskSendEmpName;
    }

    public void setTaskSendEmpName(String taskSendEmpName) {
        this.taskSendEmpName = taskSendEmpName;
    }
}
