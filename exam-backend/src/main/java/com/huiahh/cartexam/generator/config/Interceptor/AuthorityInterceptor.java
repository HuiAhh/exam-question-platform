package com.huiahh.cartexam.generator.config.Interceptor;

import com.huiahh.cartexam.generator.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        //如果是不拦截的url 直接放行
        if (url.indexOf("login") >= 0 || url.indexOf("swagger") >= 0 || url.indexOf("index") >= 0
                || url.indexOf("register") >= 0) {
            System.out.println("不拦截" + url);
            return true;
        }
//        log.info("拦截" + url);
        System.out.println("拦截" + url);
        //判断用户是否登录
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user_info_in_the_session");
        //如果没有登录则跳转到登录页面
        if (userInfo == null) {
            response.sendRedirect("/LoginController/login");
            return false;
        }
        //如果用户已经登录 则放行
        return true;
    }

}
