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
import java.util.List;

@WebServlet("/recordList")
public class recordList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        RecordService service = new RecordServiceImpl();
         List<Record> records = service.findAll();
        request.setAttribute("records",records);
        request.getRequestDispatcher("/record.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
