package com.chinasoft.dao;

import com.chinasoft.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

}
