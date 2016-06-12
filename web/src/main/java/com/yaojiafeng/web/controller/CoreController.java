package com.yaojiafeng.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.yaojiafeng.common.util.LogUtils;
import com.yaojiafeng.dao.bean.User;
import com.yaojiafeng.web.core.Response;
import com.yaojiafeng.web.event.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by yaojiafeng on 16/1/25.
 */
@Controller
@RequestMapping("/")
public class CoreController {

    private static final Logger logger = LoggerFactory.getLogger(CoreController.class);

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


    @RequestMapping(value = "/user/{userid}")
    public String queryUser(@PathVariable("userid") long userID, ModelMap model)

    {
        User u = new User();

        u.setUserID(userID);

        u.setUserName("zhaoyang");

        model.addAttribute("User", u);

        return "user";
    }

    @RequestMapping(value = "/ex")
    public String ex() throws Exception {
        LogUtils.info(logger, ("new Exception"));
        throw new Exception();
    }


    @RequestMapping(value = "/xml")
    public Response xml() {

        List<User> users = new ArrayList<>();


        User u1 = new User();
        u1.setUserID(1L);
        u1.setUserName("zhaoyang1");
        User u2 = new User();
        u2.setUserID(2L);
        u2.setUserName("zhaoyang2");
        users.add(u1);
        users.add(u2);


        Response response = new Response();
        response.setCode(0);
        response.setMsg("success");
        response.setInfo(users);
        return response;

    }
}
