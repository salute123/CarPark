package com.chinasoft.service.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.dao.impl.UserDaoImpl;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
