package com.chinasoft.domain;

import java.util.List;

public class PageInfo<T> {
    private Integer totalPage;//总页数
    private Integer pageNum;//当前页数
    private Integer rows;//记录数
    private List<T> list;//页面要显示的数据
    private Integer totalCount;//总记录数

    public PageInfo(Integer pageNum, Integer rows) {
        this.pageNum = pageNum;
        this.rows = rows;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer row) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public PageInfo(Integer totalPage, Integer pageNum, Integer rows, List<T> list, Integer totalCount) {
        this.totalPage = totalPage;
        this.pageNum = pageNum;
        this.rows = rows;
        this.list = list;
        this.totalCount = totalCount;
    }

    public PageInfo() {
    }
}
