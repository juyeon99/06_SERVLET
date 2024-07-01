package com.ohgiraffers.section02.formdata;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 인코딩 타입 확인
        System.out.println("request: " + request.getCharacterEncoding());

        // POST 방식으로 요청 내용을 확인하는 것도 GET 요청으로 파라미터를 처리하는 방식과 동일
        String name = request.getParameter("name");
        System.out.println("이름: " + name);

        System.out.println("===================================");
        // 모든 데이터의 key를 이용해서 전송된 값을 일괄처리 할 수 있다.
        System.out.println("전달받은 모든 데이터 조회");
        // Value 값이 문자열 배열일 수도 있기 때문에 String[]으로 설정
        Map<String,String[]> requestMap = request.getParameterMap();
        Set<String> keys = requestMap.keySet();

        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()){
            String key = keyIter.next();
            String[] values = requestMap.get(key);

            System.out.println("key: " + key);
            for (int i = 0; i < values.length; i++){
                System.out.println("  values[" + i + "] = " + values[i]);
            }
            System.out.println();
        }

        // parameter로 전달된 key 목록만 확인
        System.out.println("===================================");
        System.out.println("파라미터로 전달된 키 목록 확인");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String key = names.nextElement();
            System.out.println(key);
        }
    }
}
