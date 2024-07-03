package com.ohgiraffers.section03.request;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {
    /*
    * 3. request
    * 3-1. ServletRequestListener
    * - ServletRequest의 생성과 소멸에 대한 이벤트 리스너
    * 3-2. ServletRequestAttributeListener
    * - ServletRequest에 attribute를 추가, 제거, 수정하는 것에 대한 이벤트 리스너
    * */

    public RequestListenerTest(){
        // context가 로드될 때 constructor를 호출해서 인스턴스가 생성된다.
        System.out.println("request listener 인스턴스 생성");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request init");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request destroyed");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        // request에 attribute가 추가될 때 호출된다.
        System.out.println("request attribute added");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        // request에 attribute가 삭제될 때 호출된다.
        System.out.println("request attribute removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        // request의 attribute가 수정될 때 호출된다.
        System.out.println("request attribute replaced");
    }
}
