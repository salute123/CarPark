package com.chinasoft.domain;

import java.util.Date;

//出入记录类
public class Record {
   private Integer rid;
   private Date enterTime;
   private Date leaveTime;
   private Integer cid;//记录车辆的id
   private Integer settlement;//0为未结算，1为已结算
   private String cost;//费用

    public Record() {
    }

    public Record(Integer rid, Date enterTime, Date leaveTime, Integer cid, Integer settlement, String cost) {
        this.rid = rid;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.cid = cid;
        this.settlement = settlement;
        this.cost = cost;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSettlement() {
        return settlement;
    }

    public void setSettlement(Integer settlement) {
        this.settlement = settlement;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rid=" + rid +
                ", enterTime=" + enterTime +
                ", leaveTime=" + leaveTime +
                ", cid=" + cid +
                ", settlement=" + settlement +
                ", cost='" + cost + '\'' +
                '}';
    }
}
