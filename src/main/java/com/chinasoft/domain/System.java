package com.chinasoft.domain;

import java.util.Date;

//系统类
public class System {
    private Integer id;
    private Integer parking;//剩余停车位数
    private Date freeTime;//每天免费停车时间
    private Double rate;//停车费
    private Double ticketRate;//月票费用
    private Integer uid;//关联用户id
    private Integer rid;//关联日报表id
    public System() {
    }
}
