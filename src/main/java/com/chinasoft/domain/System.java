package com.chinasoft.domain;

import java.util.Date;

//系统类
public class System {
    private Integer id;
    private Integer parkNumber;//剩余停车位数
    private Date freetime;//每天免费停车时间
    private Double parkRole;//停车费
    private Double ticketRole;//月票费用
    public System() {
    }

    public System(Integer id, Integer parkNumber, Date freetime, Double parkRole, Double ticketRole) {
        this.id = id;
        this.parkNumber = parkNumber;
        this.freetime = freetime;
        this.parkRole = parkRole;
        this.ticketRole = ticketRole;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParkNumber() {
        return parkNumber;
    }

    public void setParkNumber(Integer parkNumber) {
        this.parkNumber = parkNumber;
    }

    public Date getFreetime() {
        return freetime;
    }

    public void setFreetime(Date freetime) {
        this.freetime = freetime;
    }

    public Double getParkRole() {
        return parkRole;
    }

    public void setParkRole(Double parkRole) {
        this.parkRole = parkRole;
    }

    public Double getTicketRole() {
        return ticketRole;
    }

    public void setTicketRole(Double ticketRole) {
        this.ticketRole = ticketRole;
    }

    @Override
    public String toString() {
        return "System{" +
                "id=" + id +
                ", parkNumber=" + parkNumber +
                ", freetime=" + freetime +
                ", parkRole=" + parkRole +
                ", ticketRole=" + ticketRole +
                '}';
    }
}
