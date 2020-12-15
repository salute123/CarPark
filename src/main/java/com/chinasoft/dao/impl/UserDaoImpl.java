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
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return list;
    }

    @Override
    public void addUser(User user) {
        String gender=user.getGender();
        String phoneNumber=user.getPhoneNumber();
        String carNumber=user.getCarNumber();
        String username=user.getUsername();
        String sql = "insert into user values(?,?,?,?,?,?,?)";
        template.update(sql,null,gender,phoneNumber,username,carNumber,"123456",1);
    }

    @Override
    public User findUserById(String uid) {
        String sql="select * from user where uid = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), uid);
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set gender=?,phoneNumber=?,username=?,carNumber=?,password=? ,role=? where uid=?";
        template.update(sql, user.getGender(), user.getPhoneNumber(), user.getUsername(), user.getCarNumber(), "123456", 1,user.getUid());

    }

    @Override
    public void deleteUser(String uid) {
        String sql = "delete from user where uid = ?";
        template.update(sql, uid);
    }

    @Override
    public void deleteCheckUser(String uid) {
        String sql = "delete from user where uid = ?";
        template.update(sql, uid);
    }
}
