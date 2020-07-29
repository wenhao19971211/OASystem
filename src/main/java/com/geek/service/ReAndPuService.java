package com.geek.service;

import com.geek.dao.ReAndPuDao;
import com.geek.pojo.ReAndPu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReAndPuService {
    @Autowired
    private ReAndPuDao reAndPuDao;

    /**
     * 根据id查询奖惩信息
     * @param empId
     * @return
     */
    public List<ReAndPu> findById(int empId){
        return reAndPuDao.findById(empId);
    }
}
