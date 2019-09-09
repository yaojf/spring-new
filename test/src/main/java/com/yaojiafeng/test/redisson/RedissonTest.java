package com.yaojiafeng.test.redisson;

/**
 * @author yaojiafeng
 * @since 2019/9/9 3:52 PM
 */
public class RedissonTest {

    public static void main(String[] args) {
        String key = "test123";
        // 加锁
        DistributedRedisLock.acquire(key);
        // 执行具体业务逻辑
        System.out.println(System.currentTimeMillis());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 释放锁
        DistributedRedisLock.release(key);
    }

}
