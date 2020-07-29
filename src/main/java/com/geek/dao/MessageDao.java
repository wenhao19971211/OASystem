package com.geek.dao;

import com.geek.pojo.Message;
import com.geek.pojo.ReleaseTabe;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息提醒
 */
public interface MessageDao {

    /**
     * 添加新的消息表数据
     * @param message
     * @return
     */
    public int addMessage(Message message);



    /**
     * 查询所有消息
     * @param empId
     * @return
     */
    public List<Message> findAllById(int empId);

    /**
     * 查询待审
     * @param empId
     * @return
     */
    public List<Message> findNoExamineById(int empId);

    /**
     * 查询已审
     * @param empId
     * @return
     */
    public List<Message> findExamineById(int empId);

    /**
     * 待阅
     * @param empId
     * @return
     */
    public List<Message> findNoReadById(int empId);

    /**
     * 已阅
     * @param empId
     * @return
     */
    public List<Message> findReadById(int empId);

    /**
     * 添加信息公告
     */
    public int addInfo(ReleaseTabe releaseTabe);

    /**
     * 查询信息公告
     * @return
     */
    public List<ReleaseTabe> findReleaseInfo();

}
