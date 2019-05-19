package com.project.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入前端控制器");
        HttpSession session = request.getSession();
        if (session.getAttribute(session.getId()) == null) {
            response.sendRedirect("../login.html");
            return false;
        }
        return true;
    }
}
