package com.geek.service;

import com.geek.dao.MessageDao;
import com.geek.pojo.ReleaseTabe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseInfoService {
    @Autowired
    private MessageDao messageDao;

    /**
     * 信息公告发布
     * @param releaseTabe
     * @return
     */
    public boolean addInfo(ReleaseTabe releaseTabe)
    {
        int count = messageDao.addInfo(releaseTabe);
        return count>0;
    }

    /**
     * 查询所有信息公告(5条)
     * @return
     */
    public List<ReleaseTabe> findReleaseInfo()
    {
        List<ReleaseTabe> releaseInfos = messageDao.findReleaseInfo();
        return releaseInfos;
    }

}
