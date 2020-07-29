package com.geek.bo;

import com.geek.pojo.TaskReceive;

import java.util.List;

/**
 * 任务接收表（分页）
 */
public class TaskReceive_bo {
    private List<TaskReceive> taskReceives;//该页显示的数据
    private Integer total;//总页码
    private Integer page;//当前页码
    private Integer count;//每页显示多少条数据
    private Integer num;//总共有多少条

    public TaskReceive_bo() {
    }

    public TaskReceive_bo(List<TaskReceive> taskReceives, Integer total, Integer page) {
        this.taskReceives = taskReceives;
        this.total = total;
        this.page = page;
    }

    public TaskReceive_bo(List<TaskReceive> taskReceives, Integer total, Integer page, Integer count) {
        this.taskReceives = taskReceives;
        this.total = total;
        this.page = page;
        this.count = count;
    }

    public TaskReceive_bo(List<TaskReceive> taskReceives, Integer total, Integer page, Integer count, Integer num) {
        this.taskReceives = taskReceives;
        this.total = total;
        this.page = page;
        this.count = count;
        this.num = num;
    }

    public List<TaskReceive> getTaskReceives() {
        return taskReceives;
    }

    public void setTaskReceives(List<TaskReceive> taskReceives) {
        this.taskReceives = taskReceives;
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
