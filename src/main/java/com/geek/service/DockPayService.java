package com.geek.service;

import com.geek.dao.DockPayDao;
import com.geek.pojo.DockPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 扣薪
 */
@Service
public class DockPayService {
    @Autowired
    private DockPayDao dockPayDao;

    /**
     * 根据empid和月份查询扣薪详情
     * @param empId
     * @param start
     * @param end
     * @return
     */
    public List<DockPay> findDockPayByEmpIdAndStartAndEnd(Integer empId, Date start, Date end)
    {

        List<DockPay> dockPays = dockPayDao.findDockPayByEmpIdAndStartAndEnd(empId, start, end);

        return dockPays;
    }


}
