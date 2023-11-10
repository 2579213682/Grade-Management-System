package com.gmy.pojo;

import java.util.List;
/*用来实现分页查询*/
public class PageBean<T> {
    /*数据总数*/
    private int totalCount;
    /*当前页面的数据 自定义泛型，实现不同类型的数据都能通用*/
    private List<T> rows;

    public PageBean() {
    }

    public PageBean(int totalCount, List<T> rows) {
        this.totalCount = totalCount;
        this.rows = rows;
    }

    /**
     * 获取
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取
     * @return rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "pageBean{totalCount = " + totalCount + ", rows = " + rows + "}";
    }
}
