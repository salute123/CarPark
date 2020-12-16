package com.chinasoft.service.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.dao.impl.UserDaoImpl;
import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public User findUserById(String uid) {
        return dao.findUserById(uid);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteUser(String uid) {
        dao.deleteUser(uid);
    }

    @Override
    public void deleteCheckUser(String[] ids) {
        for (String uid : ids) {
            dao.deleteCheckUser(uid);
        }

    }

        @Override
    public void addTciket(Ticket ticket) {
        dao.addTciket(ticket);
    }


    public List<Ticket> findticketAll() {
        return dao.findticketAll();
    }

    

}
