package com.chinasoft.domain;

import java.util.Date;

//日报表类
public class Report {
    private Integer rid;
    private Date reportTime;
    private Double total;//总费用统计
    private Integer uid;//关联用户id
    private Integer id;//关联系统id
    public Report() {
    }

    public Report(Integer rid, Date reportTime, Double total, Integer uid, Integer id) {
        this.rid = rid;
        this.reportTime = reportTime;
        this.total = total;
        this.uid = uid;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Report{" +
                "rid=" + rid +
                ", reportTime=" + reportTime +
                ", total=" + total +
                ", uid=" + uid +
                ", id=" + id +
                '}';
    }
}
