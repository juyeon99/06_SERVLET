package com.ohgiraffers.section02.delete;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===== delete 요청 =====");

        HttpSession session = request.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /*
        * 세션 데이터 지우는 방법
        * 1. 설정한 만료시간이 지나면 세션 만료
        * 2. removeAttribute()로 session의 attribute를 지운다.
        * 3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다.
        * */
        System.out.println("===== 세션 지우기 =====");

//        session.removeAttribute("firstName");
        session.invalidate();   // status 500 error

        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }
    }
}
