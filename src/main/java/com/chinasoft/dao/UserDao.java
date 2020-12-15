package com.chinasoft.dao;


import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void addUser(User user);
    User findUserById(String uid);
    void updateUser(User user);
    void deleteUser(String uid);
    void deleteCheckUser(String uid);
    void addTciket(Ticket ticket);
    List<Ticket> findticketAll();

}
