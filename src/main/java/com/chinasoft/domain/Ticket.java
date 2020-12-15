package com.chinasoft.domain;

import java.util.Date;

public class Ticket {
    private Integer yid;
    private Integer uid;
    private String username;
    private Date ktime;
    private Date jtime;
    private Integer cost;
    private Integer online;

    public Ticket() {
    }

    public Ticket(Integer yid, Integer uid, String username, Date ktime, Date jtime, Integer cost, Integer online) {
        this.yid = yid;
        this.uid = uid;
        this.username = username;
        this.ktime = ktime;
        this.jtime = jtime;
        this.cost = cost;
        this.online = online;
    }

    public Integer getYid() {
        return yid;
    }

    public void setYid(Integer yid) {
        this.yid = yid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getKtime() {
        return ktime;
    }

    public void setKtime(Date ktime) {
        this.ktime = ktime;
    }

    public Date getJtime() {
        return jtime;
    }

    public void setJtime(Date jtime) {
        this.jtime = jtime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getOnline() {
        return online;
    }

    public void setOnline(Integer online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "yid=" + yid +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", ktime=" + ktime +
                ", jtime=" + jtime +
                ", cost=" + cost +
                ", online=" + online +
                '}';
    }
}
