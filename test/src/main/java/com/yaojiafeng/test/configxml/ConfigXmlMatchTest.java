package com.yaojiafeng.test.configxml;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * *applicationContext.xml不匹配applicationContext.xml
 *
 * @author yaojiafeng
 * @create 2017-08-15 上午10:23
 */
public class ConfigXmlMatchTest {

    @Test
    public void testMatchXml() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:*applicationContext.xml");

        System.out.println(classPathXmlApplicationContext.getBean("nima"));
    }
}
