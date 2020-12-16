package com.chinasoft.dao;

import com.chinasoft.domain.Ticket;

import java.util.List;

public interface TicketDao {
    //    添加月票
    void addTciket(Ticket ticket);

    //    查找全部月票信息
    List<Ticket> findticketAll();

    //删除月票
    void deleteticket(Integer num);

    //修改月票
    void updateticket(Ticket ticket);
    //查找单个月票信息
    Ticket findticket(Integer yid);
}
