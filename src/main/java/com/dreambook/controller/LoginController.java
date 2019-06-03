package com.dreambook.controller;

import com.dreambook.config.AuthRealm;
import com.dreambook.doMain.Module;
import com.dreambook.doMain.Role;
import com.dreambook.doMain.User;
import com.dreambook.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginUser")
    public String loginUser(String username, String password, HttpSession session) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user = (User) subject.getPrincipal();
            Iterator<Role> it = user.getRoles().iterator();
            session.setAttribute("user", user);
            /*授权*/
            return "manager/index.html";
        } catch (Exception e) {
            return "login";//返回登录页面
        }
    }

    /*通过uid去获取此用户的权限以及菜单*/
    @RequestMapping("/findRolesAndMenusByUid")
    @ResponseBody
    public List<Map> findRolesAndMenusByUid(String uid){
        return userService.findRolesAndMenusByUid(uid);
    }


    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        // session.removeAttribute("user");
        return "login.html";
    }
}