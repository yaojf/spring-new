/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/6/12 下午8:26 $
 */
@Controller
@RequestMapping(value = "/member")
//会员中心要被拦截
public class IndexController {
    // 拦截/index.htm 方法为GET的请求
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        ModelAndView view = new ModelAndView();
        view.setViewName("shiro/index");

        Subject subject = SecurityUtils.getSubject();

        view.addObject("username",subject.getPrincipal() );

        return view;
    }

}