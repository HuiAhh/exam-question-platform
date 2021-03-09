package com.huiahh.cartexam.generator.controller;

import com.huiahh.cartexam.generator.entity.User;
import com.huiahh.cartexam.generator.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/LoginController")
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String index() {
        return "login";
    }

    /**
     * 测试页面
     * @return
     */
    @RequestMapping(value = "/test")
    public String TestUseful() {
        return "test";
    }

    /**
     * 判断用户名和密码是否合法
     * @param user
     * @return
     */
    @RequestMapping(value = "/loginJudge")
    public String login(User user) {
//        System.out.println(user.toString());
//        System.out.println("login()方法执行了");`
        //判断用户名和密码
        if ("123".equals(user.getPassword())) {
            HttpSession session = getRequest().getSession();
            UserInfo userInfo = new UserInfo(session.getId(), user);
            session.setAttribute("user_info_in_the_session", userInfo);
            return "admin";
        }
        return "login";
    }

    /**
     * 将userInfo添加到session中
     * @return
     */
    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public String userInfo() {
        HttpSession session = getRequest().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user_info_in_the_session");
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }


}
