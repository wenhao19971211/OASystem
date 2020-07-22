package com.geek.dao;

import com.geek.pojo.Message;

import java.util.List;

/**
 * 消息提醒
 */
public interface MessageDao {
    public List<Message> findAllById(int empId);
}
