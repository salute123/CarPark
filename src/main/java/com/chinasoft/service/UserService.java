package com.chinasoft.service;

import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
import com.mchange.v2.uid.UidUtils;


import java.util.List;

public interface UserService {
    List<User> findAll();

    void addUser(User user);
    User findUserById(String uid);
    void updateUser(User user);
    void deleteUser(String uid);
    void deleteCheckUser(String[] ids);
    void addTciket(Ticket ticket);
    List<Ticket> findticketAll();

}
