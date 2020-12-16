package com.chinasoft.web.servlet;

import com.chinasoft.service.UserService;
import com.chinasoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateReport")
public class UpdateReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //调用service层
        UserService userService = new UserServiceImpl();
        //调用service层的findRecordAll()方法，根据record表里面的内容往report表里插入数据
        userService.findrecordAll();
        //重定向到reportList来显示数据
        response.sendRedirect(request.getContextPath()+"/reportList?pageNum=1&rows=5");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
