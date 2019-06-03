package com.dreambook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    /*跳转到前端首页*/
    @RequestMapping("/index.html")
    public String jumpIndex() {
        return "fontend/noverify/index";
    }

    /*跳转到后台首页中间部分*/
    @RequestMapping("/welcome")
    public String jumpWelcome() {
        return "fontend/noverify/welcome";
    }

    /*管理员页面*/
    @RequestMapping("/admin-list")
    public String jumpAdmin() {
        return "manager/admin-list";
    }
}
