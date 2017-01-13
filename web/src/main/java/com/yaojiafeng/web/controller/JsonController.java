/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.web.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 2017/1/13 下午4:27 $
 */
@Controller
@RequestMapping(value = "/json")
public class JsonController {


    @RequestMapping(value = "/p", method = RequestMethod.GET)
    @ResponseBody
    public Object p() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(map);
        mappingJacksonValue.setJsonpFunction("callback");
        return mappingJacksonValue;
    }


}
