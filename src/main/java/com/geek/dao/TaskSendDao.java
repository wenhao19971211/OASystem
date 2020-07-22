package com.geek.dao;

import com.geek.pojo.TaskSend;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 任务发放dao
 */
public interface TaskSendDao {

    /**
     * 新增任务
     * @param taskSend
     * @return
     */
    public int addTaskSend(TaskSend taskSend);

    /**
     * 根据发放人和任务发放时间查询任务发放数据
     * @param empId
     * @param today
     * @return
     */
    public TaskSend findTaskSenndByEmpIdAndToday(@Param("empId") int empId,@Param("today") Date today);

}
