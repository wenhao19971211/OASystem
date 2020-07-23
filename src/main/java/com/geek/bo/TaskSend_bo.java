package com.geek.bo;

import com.geek.pojo.TaskSend;

import java.util.List;

/**
 * 任务发放表（分页）
 */
public class TaskSend_bo {
    private List<TaskSend> taskSends;//该页显示的数据
    private Integer total;//总页码
    private Integer page;//当前页码
    private Integer count;//每页显示多少条数据

    public TaskSend_bo() {
    }

    public TaskSend_bo(List<TaskSend> taskSends, Integer total, Integer page) {
        this.taskSends = taskSends;
        this.total = total;
        this.page = page;
    }

    public TaskSend_bo(List<TaskSend> taskSends, Integer total, Integer page, Integer count) {
        this.taskSends = taskSends;
        this.total = total;
        this.page = page;
        this.count = count;
    }

    public List<TaskSend> getTaskSends() {
        return taskSends;
    }

    public void setTaskSends(List<TaskSend> taskSends) {
        this.taskSends = taskSends;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
