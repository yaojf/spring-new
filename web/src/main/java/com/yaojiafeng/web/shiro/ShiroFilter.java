/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.web.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/6/12 下午8:22 $
 */
public class ShiroFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Principal principal = httpRequest.getUserPrincipal();

        if (principal != null) {
            Subject subjects = SecurityUtils.getSubject();
            // 为了简单，这里初始化一个用户。实际项目项目中应该去数据库里通过名字取用户：
            // 例如：User user = userService.getByAccount(principal.getName());
            User user = new User();
            user.setName("shiro");
            user.setPassword("123456");
            user.setRole(new Role("member"));
            if (user.getName().equals(principal.getName())) {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user
                        .getPassword());
                subjects = SecurityUtils.getSubject();
                subjects.login(token);
            } else {
                // 如果用户为空，则subjects信息登出
                if (subjects != null) {
                    subjects.logout();
                }
            }
        }
        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
