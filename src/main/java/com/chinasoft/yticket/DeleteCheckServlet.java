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
//删除选中月票
@WebServlet( "/tcdelete")
public class DeleteCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] yids = request.getParameterValues("yid");
        TicketService service = new TicketServiceImpl();
        service.deletecheckTicket(yids);
        response.sendRedirect(request.getContextPath()+"/tquery");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
