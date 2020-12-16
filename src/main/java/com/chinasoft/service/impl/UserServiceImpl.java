package com.chinasoft.service.impl;

import com.chinasoft.dao.UserDao;
import com.chinasoft.dao.impl.UserDaoImpl;
import com.chinasoft.domain.PageInfo;
import com.chinasoft.domain.Report;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;

import java.util.List;
import java.util.Map;

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
    public void findrecordAll() {
        dao.findrecordAll();
    }

    @Override
    public List<Report> findReportAll() {
        return dao.findReportAll();
    }

    @Override
    public PageInfo<Report> findReportByPage(String pageNum, String rows, Map<String, String[]> map) {
        PageInfo<Report> pageInfo = new PageInfo<>();
        Integer pages = Integer.valueOf(pageNum);
        Integer row = Integer.valueOf(rows);
//        分页查询
        List<Report> list = dao.findUserByPage(pages,row,map);
//        获取总的记录数
        Integer totalCount = dao.findTotalCount(map);
//        计算总的页数
        Integer totalPage = totalCount%row == 0?(totalCount/row):(totalCount/row+1);
        pageInfo.setPageNum(pages);
        pageInfo.setRows(row);
        pageInfo.setList(list);
        pageInfo.setTotalCount(totalCount);
        pageInfo.setTotalPage(totalPage);
        return pageInfo;
    }


    @Override
    public void deleteReport(String id) {
        dao.deleteReport(id);
    }

    @Override
    public void deleteCheckReport(String[] ids) {
        for (String uid : ids) {
            Integer id=Integer.valueOf(uid);
            dao.deleteCheckReport(id);
        }
    }


}
