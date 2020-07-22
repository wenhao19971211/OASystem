package com.geek.dao;

import com.geek.pojo.TaskReceive;

/**
 * 任务接收dao
 */
public interface TaskReceiveDao {


    /**
     * 添加新的任务接收表
     * @param taskReceive
     * @return
     */
    public int addTaskReceive(TaskReceive taskReceive);


}
