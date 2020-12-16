package com.chinasoft.domain;

import java.util.Date;

//出入记录类
public class Record {
   private Integer id;
   private String carNumber;
   private Date startime;
   private Date leavetime;
   private String jiesuan;
   private Integer uid;
   private Integer yid;
   private Integer cost;//费用

    public Record() {
    }

    public Record(Integer id, String carNumber, Date startime, Date leavetime, String jiesuan, Integer uid, Integer yid, Integer cost) {
        this.id = id;
        this.carNumber = carNumber;
        this.startime = startime;
        this.leavetime = leavetime;
        this.jiesuan = jiesuan;
        this.uid = uid;
        this.yid = yid;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getStartime() {
        return startime;
    }

    public void setStartime(Date startime) {
        this.startime = startime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public String getJiesuan() {
        return jiesuan;
    }

    public void setJiesuan(String jiesuan) {
        this.jiesuan = jiesuan;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", startime=" + startime +
                ", leavetime=" + leavetime +
                ", jiesuan='" + jiesuan + '\'' +
                ", uid=" + uid +
                ", yid=" + yid +
                ", cost='" + cost + '\'' +
                '}';
    }
}
