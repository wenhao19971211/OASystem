package com.geek.dao;

import com.geek.pojo.ReAndPu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReAndPuDao {
    /**
     * 根据Id查询奖惩记录
     * @param empId
     * @return
     */
    public List<ReAndPu> findByEmpId(int empId);

    /**
     * 查询所有奖惩记录
     * @return
     */
    public List<ReAndPu> findAll(@Param("start") int start, @Param("end") int end);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public ReAndPu findById(int id);

    /**
     *
     * @param reAndPu
     */
    public void addPrize(ReAndPu reAndPu);
}
