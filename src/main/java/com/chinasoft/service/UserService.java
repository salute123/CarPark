package com.chinasoft.service;

import com.chinasoft.domain.PageInfo;
import com.chinasoft.domain.Report;
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





    void findrecordAll();

    List<Report> findReportAll();

    PageInfo<Report> findReportByPage(String pageNum, String rows, Map<String, String[]> map);

    void deleteReport(String  id);

     void deleteCheckReport(String[] ids);
}
