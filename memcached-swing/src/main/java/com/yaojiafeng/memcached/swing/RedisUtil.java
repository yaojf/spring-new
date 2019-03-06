package com.yaojiafeng.memcached.swing;

import net.rubyeye.xmemcached.exception.MemcachedException;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * Created by yaojiafeng on 2019/3/6 11:47 AM.
 */
public class RedisUtil {

    public static void main(String[] args) throws IOException, InterruptedException, MemcachedException, TimeoutException {
        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        Jedis jedis = new Jedis(properties.getProperty("redis.host"), Integer.parseInt(properties.getProperty("redis.port")));
        jedis.auth(properties.getProperty("redis.password"));
        jedis.select(Integer.parseInt(properties.getProperty("redis.db")));
        jedis.flushDB();
        jedis.close();
    }
}
