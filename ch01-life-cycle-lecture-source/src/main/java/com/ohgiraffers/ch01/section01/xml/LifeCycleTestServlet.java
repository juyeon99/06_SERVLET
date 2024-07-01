package com.ohgiraffers.ch01.section01.xml;

import com.ohgiraffers.ch01.HelloServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LifeCycleTestServlet extends HelloServlet {
    // 각 메소드마다 호출 횟수를 카운트 할 목적의 필드
    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    // def-constructor
    public LifeCycleTestServlet(){
    }

    // 최초로 서블릿 요청시에 동작하는 메소드
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메소드 호출 " + initCount++);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 서블릿 컨테이너에 의해 호출되며 최초 요청시에는 init() 이후에 동작하고,
        * 두 번째 요청부터는 init() 호출 없이 바로 service() 호출
        * */
        System.out.println("xml 매핑 service() 메소드 호출 " + serviceCount++);
    }

    // 서블릿 컨테이너가 종료될 때 호출되는 메소드, 주로 자원을 반납하는 용도로 사용
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메소드 호출 " + destroyCount++);
    }
}
