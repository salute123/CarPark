package com.chinasoft.web.servlet;

import com.chinasoft.domain.PageInfo;
import com.chinasoft.domain.Report;
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

@WebServlet("/reportList")
public class ReportListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //调用service层
//        UserService service = new UserServiceImpl();
//        //获得结果
//        List<Report> reportList = service.findReportAll();
//        //存到域对象中
//        request.setAttribute("report",reportList);
//        //转发
//        request.getRequestDispatcher("/reportlist.jsp").forward(request,response);


        request.setCharacterEncoding("UTF-8");
        String pageNum = request.getParameter("pageNum");
        String rows = request.getParameter("rows");
//        将前台传来的参数封装到map中
        Map<String, String[]> map = request.getParameterMap();
        UserService service = new UserServiceImpl();
        PageInfo<Report> pageInfo =service.findReportByPage(pageNum,rows,map);
        request.setAttribute("pageInfo",pageInfo);


        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        session.setAttribute("a",username);
        session.setAttribute("b",address);
        session.setAttribute("c",email);
        request.getRequestDispatcher("/reportlist.jsp").forward(request,response);







    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
