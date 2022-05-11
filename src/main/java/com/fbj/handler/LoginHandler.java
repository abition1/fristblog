package com.fbj.handler;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginuser = request.getSession().getAttribute("user");
        if (loginuser == null) {

            request.setAttribute("msg", "您没有该权限，请先登录");
            request.getRequestDispatcher("/").forward(request,response);
            return  false;
        } else {
            return true;
        }
    }


}
