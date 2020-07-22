package com.geek.service;

import com.geek.dao.MessageDao;
import com.geek.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;
    public List<Message> findAllById(int empId){
        return messageDao.findAllById(empId);
    }
}
