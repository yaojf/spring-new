package com.yaojiafeng.web.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.yaojiafeng.web.event.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaojiafeng on 16/1/25.
 */
@Controller
@RequestMapping("/")
public class CoreController {

    @ResponseBody
    @RequestMapping(value = "/addUser")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = String.class, notes = "add user")
    public String addUser(@ApiParam(required = true, name = "postData", value = "用户信息json数据") @RequestParam(
            value = "postData", defaultValue = "") String postData, HttpServletRequest request) {

        return "hello";
    }


    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/send")
    public String send() {
        emailService.sendEmail("john.doe@example.org", "john.doe@example.org");
        return "success";
    }

}
