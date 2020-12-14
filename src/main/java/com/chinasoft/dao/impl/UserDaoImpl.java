package com.chinasoft.dao.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.domain.User;
import com.chinasoft.util.JDBCUtil;
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
}
