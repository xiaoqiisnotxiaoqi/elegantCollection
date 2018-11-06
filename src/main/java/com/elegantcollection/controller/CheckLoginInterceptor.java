package com.elegantcollection.controller;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录检查拦截器
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("CheckLoginInterceptor request getServletPath = " + request.getServletPath());
        System.out.println("CheckLoginInterceptor request URI = " +  request.getRequestURI());
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") != null) {
            System.out.println("拦截器:用户已登录");
            return true;
        } else {
            System.out.println("拦截器:用户未登录");
            response.sendRedirect("/index");
            return false;
        }
    }
}
