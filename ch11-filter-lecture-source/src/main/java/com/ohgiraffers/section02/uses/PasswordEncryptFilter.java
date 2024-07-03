package com.ohgiraffers.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {
    public PasswordEncryptFilter(){
        System.out.println("PasswordEncryptFilter 생성");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("암호화 필터 작동");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        // 요청을 Wrapper로 감싸서 전송
        RequestWrapper wrapper = new RequestWrapper(httpRequest);

        filterChain.doFilter(wrapper, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
