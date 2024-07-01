package com.ohgiraffers.ch02;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
//    @Override
//    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
//        HttpServletRequest httpRequest = (HttpServletRequest) req;
//        HttpServletResponse httpResponse = (HttpServletResponse) resp;
//
//        // httpRequest의 getMethod(): 어떠한 http method 요청인지 문자열로 반환
//        String httpMethod = httpRequest.getMethod();
//
//        // a태그의 href 속성은 화면의 url 내용을 변경하는 방식으로 GET 요청에 해당
//        System.out.println("http method: " + httpMethod);
//
//        if ("GET".equals(httpMethod)) {
//            // GET 요청을 처리할 메소드로 요청과 응답 정보를 전달
//            doGet(httpRequest, httpResponse);
//        } else if ("POST".equals(httpMethod)) {
//            // POST 요청을 처리할 메소드로 요청과 응답 정보를 전달
//            doPost(httpRequest, httpResponse);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}
