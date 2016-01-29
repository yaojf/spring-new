package com.yaojiafeng.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yaojiafeng on 16/1/29.
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIOException(HttpServletRequest req, Exception ex) {
        return req.getRequestURL() + "\r\n" + ClassUtils.getShortName(ex.getClass()) + "\r\n" + ex.getMessage();
    }
}
