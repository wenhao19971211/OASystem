package com.geek.service;

import com.geek.bo.PersonnelInformation_bo;
import com.geek.dao.EmpDao;
import com.geek.pojo.Emp;
import com.geek.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    /**
     * 根据用户名查询
     * @param account
     * @return
     */
    @Transactional
    public Emp findEmpByAccount(String account){
        return empDao.findEmpByAccount(account);
    }

    public Emp findEmpById(int empId){
        return empDao.findEmpById(empId);
    }

    public void updateInformation(int empId,String head,String phone,String email){
        empDao.updateEmpById(empId,head,phone,email);
    }

    /**
     * 根据部门id查询部门经理
     * @return
     */
    public Emp findManagerBydepId(int depId){
        return empDao.findManagerBydepId(depId);
    }

    /**
     * 查询人事信息（分页）
     * @param page
     * @return
     */
    public PersonnelInformation_bo findAll(int page){
        PersonnelInformation_bo person = new PersonnelInformation_bo();
        //数据总数
        int count = empDao.findCount();
        //总页数
        int pageCount = (count+CommonUtil.getPageSize()-1)/CommonUtil.getPageSize();
        int start =(page-1)*CommonUtil.getPageSize();
        int end =(page*CommonUtil.getPageSize());
        List<Emp> list = empDao.findAll(start,end);
        //封装数据
        person.setList(list);
        person.setPageCount(pageCount);
        return person;
    }

}
