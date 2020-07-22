package com.geek.dao;

import com.geek.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息提醒
 */
public interface MessageDao {
    /**
     * 根据员工id查询所有消息
     * @param empId
     * @return
     */
    public List<Message> findAllById(@Param("empId") int empId);

    /**
     * 添加新的消息表数据
     * @param message
     * @return
     */
    public int addMessage(Message message);



}
