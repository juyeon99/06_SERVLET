package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션 만들기
        HttpSession session = request.getSession();
        System.out.println("발급받은 session id: " + session.getId());

        // session 만료하면 sessionDestroyed() 동작
//        session.setMaxInactiveInterval(5);
//        session.invalidate();

        // session에 attribute를 추가할 때 attributeAdded() 메소드 동작
        session.setAttribute("username","honggildong");
        session.setAttribute("age",20);

        // DTO의 바인딩 리스너 확인
        session.setAttribute("user", new UserDTO("honggildong", 20));

        // session에 attribute에 동일한 키로 덮어쓰는 경우(수정) attributeReplaced() 메소드 동작
        session.setAttribute("username", "hong");

        // session attribute를 제거할 때 attributeRemoved() 메소드 동작
        session.removeAttribute("username");
    }
}
