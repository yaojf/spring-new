package com.yaojiafeng.web.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: yaojiafeng
 * Date: 15/11/1
 * Time: 下午7:38
 */
public class TimeInterceptor extends HandlerInterceptorAdapter {
    /**
     * This implementation always returns <code>true</code>.
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("start", System.currentTimeMillis());
        return true;
    }

    /**
     * This implementation is empty.
     */
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        Long start = (Long) request.getAttribute("start");
        long time = System.currentTimeMillis() - start;
        request.setAttribute("time", time);
    }

}
