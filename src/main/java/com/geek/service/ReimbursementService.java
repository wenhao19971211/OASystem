package com.geek.service;

import com.geek.bo.ReimbursementAll_bo;
import com.geek.dao.ReimbursementAll_boDao;
import com.geek.dao.ReimbursementDao;
import com.geek.dao.ReimbursementDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReimbursementService {

    @Autowired
    private ReimbursementDao reimbursementDao;
    @Autowired
    private ReimbursementDetailDao reimbursementDetailDao;
    @Autowired
    private ReimbursementAll_boDao reimbursementAll_boDao;

    /**
     * 将页面的数据传入到数据库中
     * @param
     */
    @Transactional
    public void insertByEmpId(int empId,int taskSenId,Date sendTime,double sum,int type,String detail){
        Date date=new Date();

        reimbursementDao.insertReimbursement(null,empId,taskSenId,sendTime,sum,date,type);
        reimbursementDetailDao.insertDetailMessge(type,detail,sum,null);

    }

    /**
     * 1、未审核；2、审核通过，等待报销费用下发； 3、报销费用已下发；4、审核未通过；5、未通过；
     * @param statue
     * @return
     */
    public List<ReimbursementAll_bo> selectAllStatue(int statue){
        List<ReimbursementAll_bo> list=new ArrayList<>();
        list=reimbursementAll_boDao.findAllReimbursement(1);
        return list;
    }


    public void updateByEmpId(int statue,int reimbursementId){
        reimbursementDao.updateSomeStatues(statue,reimbursementId);
    }
}
