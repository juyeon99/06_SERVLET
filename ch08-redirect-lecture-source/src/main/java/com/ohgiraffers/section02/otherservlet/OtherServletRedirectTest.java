package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청 정상 수락");
        System.out.println(response);
        response.sendRedirect("redirectservlet");
    }
}
