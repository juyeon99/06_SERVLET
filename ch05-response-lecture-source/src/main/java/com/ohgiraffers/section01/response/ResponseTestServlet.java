package com.ohgiraffers.section01.response;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    /*
    * 서블릿이 하는 역할
    * 1. 요청받기 - HTTP method GET/POST 요청에 따라 parameter로 전달받은 데이터를 꺼낼 수 있다.
    * 2. 비즈니스 로직 처리 - DB접속과 CRUD에 대한 로직 처리 -> 서비스를 호출하는 쪽으로 해결(MVC)
    * 3. 응답하기 - 문자열로 동적인 웹(HTML 태그)페이지를 만들고 스트림을 이용해 내보낸다.
    * */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 사용자 브라우저에 응답하기 위해서는 HttpServletResponse의 getWriter() method로 PrintWriter 인스턴스를 반환 받는다.
        * PrintWriter는 BufferedWriter와 형제격인 클래스이지만 더 많은 constructor를 제공하고 있는 범용성으로 인해 더 많이 사용됨.
        * */
        PrintWriter out = response.getWriter();

        StringBuilder responseBuilder =  new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 servlet response</h1>\n")
                .append("</body>\n")
                .append("</html>\n");

        // 브라우저로 내보낼 데이터의 타입을 응답 헤더에 설정 해줘야한다.
        // default type이 null이기 때문에 수정 필요
        System.out.println("default response type: " + response.getContentType());  // null

//        response.setContentType("text/html");
        response.setContentType("text/plain");

        // 추가사항: 인코딩 방식 변경
        response.setCharacterEncoding("UTF-8");

        // 인코딩과 MIME타입을 한번에 설정할 수 있다.
//        response.setContentType("text/html; charset=UTF-8");

        out.println(responseBuilder.toString());
        out.flush();    // 버퍼공간에서 응답 객체로 내보낼 때 사용
        out.close();
    }
}
