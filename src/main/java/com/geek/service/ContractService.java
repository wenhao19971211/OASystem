package com.geek.service;

import com.geek.bo.Contract_bo;
import com.geek.dao.ContractDao;
import com.geek.pojo.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractDao contractDao;

    /**
     * 查询合同总数
     * @return
     */
    public int findCount(){
        return contractDao.findCount();
    }
    /**
     * 查看个人合同
     * @param empId
     * @return
     */
    public Contract findContractByEmpId(int empId){
        return contractDao.findContractByEmpId(empId);
    }

    /**
     * 查看全部合同
     * @return
     */
    public List<Contract_bo> findAll(int start,int end){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<Contract_bo> list = new ArrayList<>();
        List<Contract> contracts = contractDao.findAll(start,end);
        for (Contract contract : contracts) {
            //合同类型
            int a = contract.getContractType();
            String type = "";
            if (a == 1){
                type = "劳动合同";
            }
            else if (a == 2){
                type = "劳务合同";
            }
            else if (a == 3){
                type = "聘用合同";
            }
            else if (a == 4){
                type = "保密协议";
            }
            else if (a == 5){
                type = "竞业协议";
            }
            else {
                type = "培训合同";
            }
            String contractYear = "";
            long year = (contract.getFailureTime().getTime()-contract.getEffectTime().getTime())/31536000000L;
            contractYear = year+"年";
            //封装
            Contract_bo contract_bo = new Contract_bo();
            contract_bo.setContractType(type);
            contract_bo.setContractId(contract.getContractId());
            contract_bo.setEmpId(contract.getEmp().getEmpId());
            contract_bo.setEmpName(contract.getEmp().getEmpName());
            contract_bo.setEffectTime(sdf.format(contract.getEffectTime()));
            contract_bo.setFailureTime(sdf.format(contract.getFailureTime()));
            contract_bo.setSalary(contract.getSalary());
            contract_bo.setContractYear(contractYear);
            list.add(contract_bo);
        }
        return list;
    }
}
