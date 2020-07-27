package com.geek.service;

import com.geek.bo.CheckWork_bo;
import com.geek.dao.CheckWorkDao;
import com.geek.dao.WorkOnDao;
import com.geek.pojo.CheckWork;
import com.geek.pojo.WorkOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CheckWorkService {
    @Autowired
    private CheckWorkDao checkWorkDao;
    @Autowired
    private WorkOnDao workOnDao;

    /**
     * 根据员工查询当月打卡记录
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<CheckWork_bo> findById(int empId, Date start, Date end){
        List<CheckWork_bo> list = new ArrayList<>();
        List<CheckWork> checkWorkList = checkWorkDao.findById(empId,start,end);
        List<WorkOn> workOnList = workOnDao.findByIdAndMonth(empId,start,end);
        for (CheckWork checkWork : checkWorkList) {
            for (WorkOn workOn : workOnList) {
                if (checkWork.getToday().getTime() == workOn.getToday().getTime()){
                    CheckWork_bo checkWork_bo = new CheckWork_bo();
                    checkWork_bo.setEmpId(empId);
                    checkWork_bo.setToday(workOn.getToday());
                    checkWork_bo.setWorkInTime(workOn.getWorkInTime());
                    checkWork_bo.setWorkOutTime(workOn.getWorkOutTime());
                    checkWork_bo.setIsLate(checkWork.getIsLate());
                    list.add(checkWork_bo);
                }
            }
        }
        return list;
    }
}
