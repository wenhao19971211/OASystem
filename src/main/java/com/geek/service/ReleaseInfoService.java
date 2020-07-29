package com.geek.service;

import com.geek.dao.MessageDao;
import com.geek.pojo.ReleaseTabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReleaseInfoService {
    @Autowired
    private MessageDao messageDao;

    public boolean addInfo(ReleaseTabe releaseTabe)
    {
        int count = messageDao.addInfo(releaseTabe);
        return count>0;
    }



}
