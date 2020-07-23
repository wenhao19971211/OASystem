package com.geek.dao;

import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
     * 根据任务发放id，更新状态
     * @param taskSendId
     * @param status
     * @return
     */
    public int updateStatusByTaskSendId(@Param("taskSendId") Integer taskSendId,@Param("status") Integer status);


    /**
     * 根据发放人和任务发放时间查询任务发放数据
     * @param empId
     * @param today
     * @return
     */
    public TaskSend findTaskSenndByEmpIdAndToday(@Param("empId") int empId,@Param("today") Date today);



    /**
     * 根据任务发放表id查找任务发放数据
     * @param taskSendId
     * @return
     */
    public TaskSend findTaskSendByTaskSendId(@Param("taskSendId") Integer taskSendId);

    /**
     * 根据任务发放者查询任务发放数据
     * @param empId
     * @return
     */
    public List<TaskSend> findTaskSendByEmpId(@Param("empId") Integer empId,@Param("pageSize") Integer pageSize ,@Param("index") Integer index);

    /**
     * 根据员工如何任务标题查询有关他发放和接收的任务
     * @param empId
     * @param title
     * @param pageSize
     * @param index
     * @return
     */
    public List<TaskSend> findTaskSendByTitleAndReEmpIdAndSeEmpId(@Param("empId") Integer empId,@Param("title") String title,@Param("pageSize") Integer pageSize ,@Param("index") Integer index);

}
