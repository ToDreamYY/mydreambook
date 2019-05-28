package com.dreambook.config;

import com.dreambook.doMain.Module;
import com.dreambook.doMain.Role;
import com.dreambook.doMain.User;
import com.dreambook.service.UserService;
import com.mysql.cj.Session;
import org.apache.shiro.authc.*;

import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        if(token==null){
            return null;
        }
        System.out.println("获取密码校验");
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.findByUserName(username);
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        System.out.println("我开始获取权限");
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions=new ArrayList<>();
        Set<Role> roles = user.getRoles();
        if(roles.size()>0) {
            for(Role role : roles) {
                Set<Module> modules = role.getModules();
                if(modules.size()>0) {
                    for(Module module : modules) {
                        permissions.add(module.getMname());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        System.out.println("我的权限有"+permissions);
        System.out.println("我的权限有"+info);
        return info;
    }

}