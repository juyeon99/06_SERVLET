package com.ohgiraffers.section03.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/request")
public class RequestListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request에 attribute를 추가할 때 attributeAdded() 메소드 동작
        request.setAttribute("username","honggildong");
        request.setAttribute("age",20);
        request.setAttribute("gender","M");

        // request에 attribute를 동일한 key로 덮어쓰는 경우(수정) attributeReplaced() 메소드 동작
        request.setAttribute("username","hong");

        // request에 attribute를 제거할 때 attributeRemoved() 메소드 동작
        request.removeAttribute("gender");
    }
}
