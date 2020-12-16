package com.chinasoft.service.impl;

import com.chinasoft.dao.TicketDao;
import com.chinasoft.dao.UserDao;
import com.chinasoft.dao.impl.TicketDaoImpl;
import com.chinasoft.dao.impl.UserDaoImpl;
import com.chinasoft.domain.Ticket;
import com.chinasoft.service.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    private TicketDao dao = new TicketDaoImpl();
    //    添加月票
    @Override
    public void addTciket(Ticket ticket) {
        dao.addTciket(ticket);
    }

    //    查找全部月票信息
    @Override
    public List<Ticket> findticketAll() {
        return dao.findticketAll();
    }

    //删除月票信息
    @Override
    public void deleteticket(String yid) {
        Integer num = Integer.valueOf(yid);
        dao.deleteticket(num);
    }
    //批量删除月票信息
    @Override
    public void deletecheckTicket(String[] yids) {
        for (String yid : yids) {
            Integer id = Integer.valueOf(yid);
            dao.deleteticket(id);
        }
    }
    // 修改月票信息
    @Override
    public void updateticket(Ticket ticket) {
        dao.updateticket(ticket);
    }
    //查找单个月票信息
    @Override
    public Ticket findticket(String yid) {
        Integer num = Integer.valueOf(yid);
        return dao.findticket(num);
    }
}
