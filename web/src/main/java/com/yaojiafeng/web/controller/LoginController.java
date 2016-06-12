/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.web.controller;

import com.yaojiafeng.web.shiro.Role;
import com.yaojiafeng.web.shiro.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/6/12 下午8:25 $
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submit(String username, String password) {
        User user = new User("shiro", "123456");
        user.setRole(new Role("member"));
        try {
            // 如果登陆成功
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user
                        .getPassword().toString());
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ModelAndView("redirect:/member/index");
    }
}