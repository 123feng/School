package com.iflytek.tms.interception;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author XiaoFeng
 * @date 2019/4/26 - 15:29
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取url地址
        String url = request.getRequestURI();
        //如果包含resources 拦截器发放行
        if (url.contains("resources")) {
           return true;
           //否则判断url知否包含login ，如果包含就放行
        } else {

            if (url.toLowerCase().contains("login")) {
                System.out.println(url);
               return true;
          //否则判断用户是否为登录状态 ，如果不是登录状态，就拦截，直接跳到登录界面
            } else {
                HttpSession session = request.getSession();
                if (session.getAttribute("user") == null || session == null) {
                    response.sendRedirect(request.getContextPath() + "/tologin");
                    return false;
                } else {
                    // 有session，允许访问
                    return true;
                }
            }
        }

    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
