package com.chinasoft.service;

import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void addTciket(Ticket ticket);
    List<Ticket> findticketAll();
}
