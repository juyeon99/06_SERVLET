package com.ohgiraffers.section01.cookie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("(cookie) firstName = " + firstName);
        System.out.println("(cookie) lastName = " + lastName);

        /*
        * 쿠키 사용 절차
        * 1. 쿠키 생성
        * 2. 생성한 쿠키의 만료 시간 설정
        * 3. 응답 헤더에 쿠키 담기
        * 4. 응답 보내기
        *
        * 쿠키의 제약사항
        * 쿠키의 이름은 ascii 문자만을 사용해야하며 한 번 설정한 쿠키 이름은 변경 불가
        * 쿠키의 이름에는 공백문자와 일부 특수문자( [ ] ( ) = , " \ ? @ : ; ) 사용 불가
        * */

        // def-constructor를 제공하지 X
        Cookie firstNameCookie = new Cookie("firstName",firstName);
        Cookie lastNameCookie = new Cookie("lastName",lastName);

        // 초 단위 설정 (만료 시간을 하루로 설정)
        firstNameCookie.setMaxAge(60 * 60 * 24);
        lastNameCookie.setMaxAge(60 * 60 * 24);

        // response에 쿠키 담기
        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");
    }
}
