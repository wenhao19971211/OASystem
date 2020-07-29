package com.geek.service;

import com.geek.dao.EmailDao;
import com.geek.dao.MessageDao;
import com.geek.pojo.Email;
import com.geek.pojo.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailDao emailDao;


    /**
     * 发送（回复）邮件的同时接收邮件事务
     * @param sendEmpId 发送者的id
     * @param receiveEmpId 接收者的id
     * @param title 标题
     * @param content 内容
     * @param emailType 邮件类型
     */
    @Transactional
   public void addEmail(int sendEmpId,int receiveEmpId,String title,String content,int emailType){
        if (emailType!=3){
            emailDao.addSendEmail(sendEmpId,title,content,1,receiveEmpId);

        }else {
            emailDao.addSendEmail(sendEmpId,title,content,3,receiveEmpId);
        }
        emailDao.addSendEmail(sendEmpId,title,content,2,receiveEmpId);

        System.out.println("添加成功");

    }

    /**
     * 查看邮件
     * @param empId
     * @param emailType
     * @param readStatus
     * @return
     */
    @Transactional
    public List<Email> findEmail(int emailId,int empId, int emailType, int readStatus, int receiveEmpId){
        return emailDao.selectEmail(emailId,empId,emailType,readStatus,receiveEmpId);
    }

    /**
     * 修改邮件阅读状态
     * @param readStatus
     * @param emailId
     */
    @Transactional
    public void updateReadStatusByEmailId(int readStatus,int emailId){
        emailDao.updateReadStatusByEmailId(readStatus,emailId);
    }
}
