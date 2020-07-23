package com.geek.dao;

import com.geek.pojo.TaskReceive;
import com.geek.pojo.TaskSend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据任务接收id更改任务完成状态
     * @param taskReceiveId
     * @param status
     * @return
     */
    public int updateStatusByTaskReceiveId(@Param("taskReceiveId") Integer taskReceiveId,@Param("status") Integer status);


    /**
     * 根据任务完成状态查询任务接收数据
     * @param status
     * @return
     */
    public List<TaskReceive> findTaskReceivesByStatusAndEmpId(@Param("status") Integer status,@Param("empId") Integer empId,@Param("pageSize") Integer pageSize,@Param("index") Integer index);

    /**
     * 根据任务发送id查询所有的接收信息
     * @param taskSendId
     * @return
     */
    public List<TaskReceive> findTaskReceivesByTaskSendId(@Param("taskSendId") Integer taskSendId);

    /**
     * 根据任务接收id，查询接收数据
     * @param taskReceiveId
     * @return
     */
    public TaskReceive findTaskReceiveByTaskReceiveId(@Param("taskReceiveId") Integer taskReceiveId);

}
