package com.chinasoft.dao.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
import com.chinasoft.util.JDBCUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return template.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void addTciket(Ticket ticket) {

            String sql = "insert into yticket(uid,username,carNumber,ktime,jtime,cost) values (?,?,?,?,?,?)";
            template.update(sql,ticket.getUid(),ticket.getUsername(),ticket.getCarNumber(),ticket.getKtime(),ticket.getJtime(),ticket.getCost());

    }

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
}
