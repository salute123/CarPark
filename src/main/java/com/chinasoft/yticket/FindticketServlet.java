package com.chinasoft.yticket;

import com.chinasoft.domain.Ticket;
import com.chinasoft.domain.User;
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
//查找单个月票信息
@WebServlet("/findticket")
public class FindticketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("yid");
        TicketService service = new TicketServiceImpl();
        Ticket fticket = service.findticket(id);
        request.getSession().setAttribute("tic",fticket);
        response.sendRedirect(request.getContextPath()+"/updTicket.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
