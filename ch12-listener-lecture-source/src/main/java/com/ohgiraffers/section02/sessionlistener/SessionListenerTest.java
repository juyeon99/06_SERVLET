package com.ohgiraffers.section02.sessionlistener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {
    /*
    * Session
    * 2-1. HttpSessionListener
    *   - Http 세션의 시작, 종료에 대한 리스너
    * 2-2. HttpSessionAttributeListener
    *   - HttpSession에 attribute가 추가, 제거, 수정에 대한 리스너
    * */

    public SessionListenerTest(){
        // context가 로드될 때 인스턴스가 생성된다.
        System.out.println("session listener constructor");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("===== 새로운 세션 생성 =====");
        System.out.println("session created");
        System.out.println("created session: " + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        // session에 attribute가 추가될 때 동작
        System.out.println("session attribute added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        // session에 attribute가 삭제될 때 동작
        System.out.println("session attribute removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        // session의 attribute가 변경될 때 동작
        System.out.println("session attribute replaced");
    }
}
