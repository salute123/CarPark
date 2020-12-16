package com.chinasoft.yticket;

import com.chinasoft.domain.Ticket;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//修改月票信息
@WebServlet("/tupdate")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            String yid = request.getParameter("yid");
            String uid = request.getParameter("uid");
            String username = request.getParameter("username");
            String carNumber = request.getParameter("carNumber");
            String ktime = request.getParameter("ktime");
            String jtime = request.getParameter("jtime");
            String cost = request.getParameter("cost");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date date1 = simpleDateFormat.parse(ktime);
            Date date2 = simpleDateFormat.parse(jtime);
            Ticket ticket = new Ticket();
            ticket.setYid(Integer.parseInt(yid));
            ticket.setUid(Integer.parseInt(uid));
            ticket.setUsername(username);
            ticket.setCarNumber(carNumber);
            ticket.setKtime(date1);
            ticket.setJtime(date2);
            ticket.setCost(Integer.parseInt(cost));
            TicketService service = new TicketServiceImpl();
            service.updateticket(ticket);


            response.sendRedirect(request.getContextPath()+"/tquery");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
