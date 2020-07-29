package com.geek.dao;

import com.geek.pojo.Email;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 邮件dao
 */
public interface EmailDao {
    /**
     * 往邮件发送表加数据
     * @param empId 发送人id
     * @param title 标题
     * @param content 内容
     * @param emailType 邮件类型1.发送 2.接收 3.回复
     */
    public void addSendEmail(@Param("id") int empId, @Param("title") String title, @Param("content") String content, @Param("emailType") int emailType,@Param("receiveEmpId")int receiveEmpId);

    /**
     * 查看邮件
     * @param empId 相关员工的编号
     * @param emailType 类型
     * @param readStatus 读取状态
     */
    public List<Email> selectEmail(@Param("emailId")int emailId,@Param("id")int empId, @Param("type")int emailType, @Param("readStatus")int readStatus,@Param("receiveEmpId")int receiveEmpId);

    /**
     * 根据邮件编号修改邮件的阅读状态
     * @param readStatus
     * @param emailId
     */
    public void updateReadStatusByEmailId(@Param("readStatus") int readStatus,@Param("emailId") int emailId);
}
