package com.ohgiraffers.section01.queryString;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/querystring") // url은 소문자로 하는 것이 암묵적 규칙
public class QueryStringTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * HttpServlet 클래스의 service method는 요청 방식에 따라
        * GET 요청에 대해서는 doGet() 메소드를 호출하고 request, response를 전달
        * */

        // Service로부터 전달받은 HttpServletRequest는
        // 요청시 전달한 값을 getParameter()로 추출할 수 있다.
        String name = request.getParameter("name");
        System.out.println("이름 = " + name);

        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 = " + age);

        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        System.out.println("생일 = " + birthday);

        String gender = request.getParameter("gender");
        System.out.println("성별 = " + gender);

        String nationality = request.getParameter("nationality");
        System.out.println("국적 = " + nationality);

        String[] hobbies = request.getParameterValues("hobbies");
        System.out.print("취미: ");
        for (String hobby : hobbies){
            System.out.print(hobby + " ");
        }
    }
}
