package com.chinasoft.web.servlet;

import com.chinasoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCheckUser")
public class DeleteCheckUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String[] ids = request.getParameterValues("selectId");
        UserServiceImpl service = new UserServiceImpl();
        service.deleteCheckUser(ids);
        response.sendRedirect(request.getContextPath()+"/UserServlet?pageNum=1&rows=5");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
