package com.chinasoft.domain;

import java.util.Date;

//出入记录类
public class Record {
  private Integer id;
  private String carNumber;
   private Date startTime;
   private Date leaveTime;
   private Integer jiesuan;
   private Integer uid;
   private Integer yid;
    public Record() {
    }

    public Record(Integer id, String carNumber, Date startTime, Date leaveTime, Integer jiesuan, Integer uid, Integer yid) {
        this.id = id;
        this.carNumber = carNumber;
        this.startTime = startTime;
        this.leaveTime = leaveTime;
        this.jiesuan = jiesuan;
        this.uid = uid;
        this.yid = yid;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getJiesuan() {
        return jiesuan;
    }

    public void setJiesuan(Integer jiesuan) {
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

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", carNumber='" + carNumber + '\'' +
                ", startTime=" + startTime +
                ", leaveTime=" + leaveTime +
                ", jiesuan=" + jiesuan +
                ", uid=" + uid +
                ", yid=" + yid +
                '}';
    }

}
