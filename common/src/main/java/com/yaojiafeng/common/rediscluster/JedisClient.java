package com.yaojiafeng.common.rediscluster;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.util.HashSet;

/**
 * JedisCluster配置地址只要配置一个node的地址即可
 * <p>
 * <p>
 * Created by yaojiafeng on 2017/6/1 下午7:01.
 */
public class JedisClient {

    /**
     * 集群
     */
    public static void cluster() {
        HashSet<HostAndPort> set = new HashSet<>();
        set.add(new HostAndPort("172.30.193.102", 6379));

        JedisCluster jedisCluster = new JedisCluster(set, 2000, 5, new GenericObjectPoolConfig());

        jedisCluster.set("key", "value");

        System.out.println(jedisCluster.get("key"));

        jedisCluster.del("key");
    }


    /**
     * 单机
     */
    public static void single() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000l);
        config.setTestOnBorrow(false);

        JedisPool jedisPool = new JedisPool(config, "172.30.195.16", 6379);

        Jedis jedis = jedisPool.getResource();

        jedis.set("key", "value");

        System.out.println(jedis.get("key"));

        jedis.del("key");
    }

    public static void main(String[] args) {
        cluster();
        single();
    }


}
