package com.yaojiafeng.common.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yaojiafeng on 2017/4/18 下午3:22.
 */
public class SpringCache {


    /**
     * 加缓存
     *
     * value=data 代表1级key 从EhCacheCacheManager获取Cache
     * key=#id 代表2级key 从Cache获取
     * @param id
     * @return
     */
    @Cacheable(value = "data", key = "#id")
    public String getData(String id) {
        return id + ":" + System.currentTimeMillis();
    }

    /**
     * 清缓存
     * @param id
     */
    @CacheEvict(value = "data", key = "#id")
    public void setData(String id) {
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("/cache/spring-cache.xml");
        SpringCache springCache = (SpringCache) classPathXmlApplicationContext.getBean("springCache");
        String data = springCache.getData("1");
        System.out.println(data);

        springCache.setData("1");

        String data1 = springCache.getData("1");
        System.out.println(data1);

        String data2 = springCache.getData("2");
        System.out.println(data2);

    }
}
