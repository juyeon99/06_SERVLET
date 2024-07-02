package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/redirectservlet")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("서블릿으로 redirect 성공");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>이 서블릿으로 redirect 성공!</h1>")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println(responseText.toString());
        out.flush();
        out.close();

        /*
        * Redirect하면 url이 재작성되어 새로고침 할 때 redirect된 페이지에 대한 요청을 반복
        * 즉, 이전 요청에 포함된 정보는 남아있지 않고 url이 변경되는 것이 redirect의 특징
        * 따라서 첫 요청시의 request와 현재 redirect된 페이지의 request는 서로 다른 객체이므로
        * redirect를 쓰면 이전 서블릿의 값의 공유해서 사용 할 수 없다.
        * */
    }
}
