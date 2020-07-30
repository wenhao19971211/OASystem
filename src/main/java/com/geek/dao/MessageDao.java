package com.geek.dao;

import com.geek.pojo.Message;
import com.geek.pojo.ReleaseTabe;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

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
    public List<Message> findAllById(@Param("empId") Integer empId, @Param("limit") Integer limit,@Param("index") Integer index);

    /**
     * 查询待审
     * @param empId
     * @return
     */
    public List<Message> findNoExamineById(@Param("empId") Integer empId, @Param("limit") Integer limit,@Param("index") Integer index);

    /**
     * 查询已审
     * @param empId
     * @return
     */
    public List<Message> findExamineById(@Param("empId") Integer empId, @Param("limit") Integer limit,@Param("index") Integer index);

    /**
     * 待阅
     * @param empId
     * @return
     */
    public List<Message> findNoReadById(@Param("empId") Integer empId, @Param("limit") Integer limit,@Param("index") Integer index);

    /**
     * 已阅
     * @param empId
     * @return
     */
    public List<Message> findReadById(@Param("empId") Integer empId, @Param("limit") Integer limit,@Param("index") Integer index);

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
