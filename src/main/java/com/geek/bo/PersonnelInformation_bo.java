package com.geek.bo;

import com.geek.pojo.Emp;

import java.util.List;

/**
 * 人事信息（分页）
 */
public class PersonnelInformation_bo {

    private List<Emp> list;
    private Integer pageCount;

    public List<Emp> getList() {
        return list;
    }

    public void setList(List<Emp> list) {
        this.list = list;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
