package com.yaojiafeng.common.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yaojiafeng on 2017/4/18 下午3:22.
 */
public class SpringCache {


    @Cacheable(value = "data", key = "#id")
    public String getData(String id) {
        return id + ":" + System.currentTimeMillis();
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/cache/spring-cache.xml");
        SpringCache springCache = (SpringCache) classPathXmlApplicationContext.getBean("springCache");
        String data = springCache.getData("1");
        System.out.println(data);

        String data1 = springCache.getData("1");
        System.out.println(data1);

        String data2 = springCache.getData("2");
        System.out.println(data2);

    }
}
