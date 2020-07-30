package com.geek.service;

import com.geek.bo.Prize_bo;
import com.geek.dao.ReAndPuDao;
import com.geek.pojo.ReAndPu;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReAndPuService {
    @Autowired
    private ReAndPuDao reAndPuDao;

    /**
     * 根据empid查询奖惩信息
     * @param empId
     * @return
     */
    public List<ReAndPu> findByEmpId(int empId){

        return reAndPuDao.findByEmpId(empId);
    }

    /**
     * 根据Id查询奖惩信息
     * @param id
     * @return
     */
    public Prize_bo findById(int id){
        Prize_bo prize_bo = new Prize_bo();
        ReAndPu reAndPu = reAndPuDao.findById(id);
        String type = "";
        String item = "";
        if (reAndPu.getType() == 1){
            type = "奖励";
        }
        else {
            type = "惩罚";
        }
        if (reAndPu.getItem() == 1){
            item = "季度之星";
        }
        else if (reAndPu.getItem() == 2){
            item = "优秀员工";
        }
        else if (reAndPu.getItem() == 3){
            item = "优秀团队";
        }
        else if (reAndPu.getItem() == 4){
            item = "警告";
        }
        else{
            item = "严重警告";
        }
        prize_bo.setRewardAndPuishId(reAndPu.getRewardAndPuishId());
        prize_bo.setCompany("极客营");
        prize_bo.setType(type);
        prize_bo.setItem(item);
        prize_bo.setCause(reAndPu.getCause());
        prize_bo.setMoney(reAndPu.getMoney());
        prize_bo.setReAndPuTime(CommonUtil.parseString(reAndPu.getReAndPuTime()));
        prize_bo.setEmpName(reAndPu.getEmp().getEmpName());
        return prize_bo;
    }
    /**
     * 查询所有奖惩信息
     * @return
     */
    public List<ReAndPu> findAll(int start,int end){
        return reAndPuDao.findAll(start,end);
    }

    /**
     * 添加奖惩信息
     * @param reAndPu
     */
    public void addPrize(ReAndPu reAndPu){
        reAndPuDao.addPrize(reAndPu);
    }
}
