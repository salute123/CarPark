package com.chinasoft.domain;

import java.util.Date;

//日报表类
public class Report {
    private Integer id;
    private Date date;
    private Double income;//总费用统计

    public Report() {
    }

    public Report(Integer id, Date date, Double income) {
        this.id = id;
        this.date = date;
        this.income = income;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", date=" + date +
                ", income=" + income +
                '}';
    }
}
