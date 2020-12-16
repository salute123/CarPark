package com.chinasoft.service;

import com.chinasoft.domain.Ticket;

import java.util.List;

public interface TicketService {
    //    添加月票
    void addTciket(Ticket ticket);
    //    查找全部月票信息
    List<Ticket> findticketAll();
    //删除月票信息
    void deleteticket(String yid);
    //   批量删除月票信息
    void deletecheckTicket(String[] yids);
    //    修改月票信息
    void updateticket(Ticket ticket);
    //查找单个月票信息
    Ticket findticket(String yid);
}
