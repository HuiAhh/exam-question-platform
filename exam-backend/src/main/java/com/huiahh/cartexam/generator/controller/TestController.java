package com.huiahh.cartexam.generator.controller;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
@Api(tags = "对SpringSecurity的测试类")
public class TestController {

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello security";
    }

    @GetMapping("index")
    @ResponseBody
    public String index() {
        return "hello index";
    }

    @GetMapping("logout")
    public String logout() {
        return "login.html";
    }

}

