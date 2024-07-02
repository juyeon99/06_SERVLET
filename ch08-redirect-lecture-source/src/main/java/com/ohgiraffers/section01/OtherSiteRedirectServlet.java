package com.ohgiraffers.section01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/othersite")
public class OtherSiteRedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청 후 NAVER 사이트로 redirect");
        response.sendRedirect("http://www.naver.com");
    }
}
