package com.yaojiafeng.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yaojiafeng
 * @create 2017-12-12 下午3:36
 */
@Controller
public class TimeController {

    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public String time() {
        return "index";
    }

}
