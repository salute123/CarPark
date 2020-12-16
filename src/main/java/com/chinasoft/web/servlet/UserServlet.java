package com.chinasoft.web.servlet;

import com.chinasoft.domain.PageInfo;
import com.chinasoft.domain.User;
import com.chinasoft.service.UserService;
import com.chinasoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
//        将前台传来的参数封装到map中
        Map<String, String[]> map = request.getParameterMap();
        UserService service = new UserServiceImpl();
       PageInfo<User> pageInfo =service.findUserByPage(pageNum,rows,map);
        request.setAttribute("pageInfo",pageInfo);
       HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String carNumber = request.getParameter("carNumber");
        String phoneNumber = request.getParameter("phoneNumber");
        session.setAttribute("a",username);
        session.setAttribute("b",carNumber);
        session.setAttribute("c",phoneNumber);
        request.getRequestDispatcher("/userlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
