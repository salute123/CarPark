package com.chinasoft.service;


import com.chinasoft.domain.PageInfo;
import com.chinasoft.domain.User;
import com.mchange.v2.uid.UidUtils;


import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    void addUser(User user);
    User findUserById(String uid);
    void updateUser(User user);
    void deleteUser(String uid);
    void deleteCheckUser(String[] ids);
    PageInfo<User> findUserByPage(String pageNum, String rows, Map<String, String[]> parameterMap);


}
