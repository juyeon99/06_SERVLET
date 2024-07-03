package com.ohgiraffers.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("(redirect) firstName = " + firstName);
        System.out.println("(redirect) lastName = " + lastName);

        HttpSession session = request.getSession();
        System.out.println("redirect 페이지 session id: " + session.getId());

        // 세션에 담긴 모든 Attribute 키 목록 반환 받기
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        // 동일한 아이디를 가진 session에서는 setAttribute()에 값을 저장할 수 있고
        // getAttribute()에서 값을 꺼내올 수 있다.

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>your first name is ")
                .append(firstName)
                .append(", and your last name is ")
                .append(lastName)
                .append(".</h3>\n")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseText.toString());
        out.flush();
        out.close();
    }
}
