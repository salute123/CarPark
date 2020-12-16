package com.chinasoft.web.record;

import com.chinasoft.domain.Record;
import com.chinasoft.service.RecordService;
import com.chinasoft.service.impl.RecordServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet("/addRecord")
public class AddRecord extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String carNumber = request.getParameter("carNumber");
        String s = request.getParameter("jiesuan");
        String startime = request.getParameter("startime");
        System.out.println(startime);
        String leavetime = request.getParameter("leavetime");
        String cost = request.getParameter("cost");
        Record record = new Record();
        record.setCarNumber(carNumber);
        record.setJiesuan(s);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
        try {
            Date  date1 = simpleDateFormat.parse(startime);
            Date  date2 = simpleDateFormat.parse(leavetime);
            record.setStartime(date1);
            record.setLeavetime(date2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        record.setCost(Double.parseDouble(cost));
        RecordService recordService = new RecordServiceImpl();
        recordService.addRecord(record);
        response.sendRedirect(request.getContextPath()+"/recordList");
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
