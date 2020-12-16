package com.chinasoft.yticket;

import com.chinasoft.service.TicketService;
import com.chinasoft.service.UserService;
import com.chinasoft.service.impl.TicketServiceImpl;
import com.chinasoft.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//删除月票
@WebServlet("/tdelete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String yid = request.getParameter("yid");
        TicketService Service = new TicketServiceImpl();
        Service.deleteticket(yid);

        response.sendRedirect(request.getContextPath()+"/tquery");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
