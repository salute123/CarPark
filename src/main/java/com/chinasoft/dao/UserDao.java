package com.chinasoft.dao;


import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    User findUserById(String uid);
    void updateUser(User user);
    void deleteUser(String uid);
    void deleteCheckUser(String uid);
    List<User> findUserByPage(Integer pages, Integer row, Map<String, String[]> map);
    Integer findTotalCount(Map<String, String[]> map);



}
