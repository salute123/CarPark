package com.chinasoft.dao.impl;

import com.chinasoft.dao.TicketDao;
import com.chinasoft.domain.Ticket;
import com.chinasoft.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TicketDaoImpl implements TicketDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    //    添加月票
    @Override
    public void addTciket(Ticket ticket) {

        String sql = "insert into yticket(uid,username,carNumber,ktime,jtime,cost) values (?,?,?,?,?,?)";
        template.update(sql,ticket.getUid(),ticket.getUsername(),ticket.getCarNumber(),ticket.getKtime(),ticket.getJtime(),ticket.getCost());

    }
    //    查找全部月票信息
    @Override
    public List<Ticket> findticketAll() {
        try {
            String sql = "select * from yticket";
            return template.query(sql,new BeanPropertyRowMapper<>(Ticket.class));
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //删除月票
    @Override
    public void deleteticket(Integer num) {
        String sql = "delete from yticket where yid=?";
        template.update(sql,num);
    }
    //修改月票信息
    @Override
    public void updateticket(Ticket ticket) {
        String sql = "update yticket set  ktime=?, jtime=?, cost=?  where yid=?";
        template.update(sql,ticket.getKtime(),ticket.getJtime(),ticket.getCost(),ticket.getYid());

    }
    //查找一个月票信息
    @Override
    public Ticket findticket(Integer yid) {
        try {
            String sql = "select * from yticket where yid = ?";
            return  template.queryForObject(sql,new BeanPropertyRowMapper<>(Ticket.class),yid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
