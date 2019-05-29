package com.dreambook.controller;

import com.dreambook.config.AuthRealm;
import com.dreambook.doMain.Module;
import com.dreambook.doMain.Role;
import com.dreambook.doMain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/loginUser")
    public String loginUser(String username, String password, HttpSession session) {
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);   //完成登录
            User user=(User) subject.getPrincipal();
            Iterator<Role> it = user.getRoles().iterator();
            List modeles = new ArrayList<>();
            while (it.hasNext()) {
                Role role = it.next();
                /*role.getRname()是登录用户的权限*/
                Iterator<Module> modele = role.getModules().iterator();
                while (modele.hasNext()) {
                    Module mo = modele.next();
                    modeles.add(mo.getMname());
                    /*mo.getMname()这是登录用户能看到的权限菜单*/
                }
            }
            session.setAttribute("user", user);
            session.setAttribute("list", modeles);
            /*授权*/
            return "manager/index";
        } catch(Exception e) {
            return "login";//返回登录页面
        }

    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    // session.removeAttribute("user");
        return "login.html";
    }
}