package com.ohgiraffers.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/first/filter")
public class FirstFilterTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet 요청 확인");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!doctype html>\n");
        out.println("<html>\n");
        out.println("<head>\n");
        out.println("</head>\n");
        out.println("<body>\n");
        out.println("<h3>필터 확인용 서블릿 요청 확인 완료</h3>\n");
        out.println("</body>\n");
        out.println("</html>\n");

        out.flush();
        out.close();
    }
}
