package com.yaojiafeng.common.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by yaojiafeng on 2017/4/17 上午10:33.
 */
public class Guavas {

    private static final Logger logger = LoggerFactory.getLogger(Guavas.class);

    /**
     * 每秒速率控制器
     *
     * @param permitsPerSecond
     * @return
     */
    public static void rateLimiter(double permitsPerSecond) {
        RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond);
        while (true) {
            rateLimiter.acquire();
            System.out.println(System.currentTimeMillis());
        }
    }

    /**
     * 字符串连接
     */
    public static void joiner() {
        Joiner joiner = Joiner.on("; ").skipNulls();
        String join = joiner.join("Harry", null, "Ron", "Hermione");
        System.out.println(join);
    }

    /**
     * 字符串分割
     */
    public static void splitter() {
        Iterable<String> iterable = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");

        for (String str : iterable) {
            System.out.println(str);
        }

    }

    /**
     * 缓存
     */
    public static String cache(String key) {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).expireAfterAccess(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    public String load(String key) {
                        return key;
                    }
                });
        try {
            return graphs.get(key);
        } catch (ExecutionException e) {
            logger.error("", e);
            return null;
        }
    }


    /**
     * Objects使用
     */
    public static void objects() {
        System.out.println(Objects.equal("a", "a"));

    }

    public static void main(String[] args) {
        rateLimiter(1.0);
        joiner();
        splitter();
        logger.info("logback 成功了");

        objects();
    }


}