package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author Mxw
 * @create 2019/6/19
 */
public class App {
    @Test
    public void test01() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "1234");
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                System.out.println("登陆成功");
            }
        } catch (AuthenticationException e) {
                System.out.println("登陆失败");
            e.printStackTrace();
        }
        subject.logout();
        System.out.println("退出登录");

    }
}
