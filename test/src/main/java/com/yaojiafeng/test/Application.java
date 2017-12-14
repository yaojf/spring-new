package com.yaojiafeng.test;

import com.yaojiafeng.test.aop.HelloService;
import com.yaojiafeng.test.aop.HelloServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yaojiafeng
 * @create 2017-12-14 下午2:40
 */
public class Application {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        System.out.println(helloService.hello());
    }
}
