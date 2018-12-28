package com.yaojiafeng.memcached.swing;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.TimeoutException;

/**
 * Created by yaojiafeng on 2018/8/21 下午7:29.
 */
public class MemcachedUtil {

    public static void main(String[] args) throws IOException, InterruptedException, MemcachedException, TimeoutException {

        Properties properties = new Properties();
        properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));

        Map<InetSocketAddress, AuthInfo> authInfoMap = new HashMap<InetSocketAddress, AuthInfo>();

        List<InetSocketAddress> addressList = new ArrayList<InetSocketAddress>();
        InetSocketAddress address = AddrUtil.getOneAddress(properties.getProperty("memcached.host") + ":" + properties.getProperty("memcached.port"));
        addressList.add(address);
        authInfoMap.put(address, AuthInfo.plain(properties.getProperty("memcached.username"), properties.getProperty("memcached.password")));

        MemcachedClientBuilder builder = new XMemcachedClientBuilder(addressList);
        builder.setAuthInfoMap(authInfoMap);
        builder.setCommandFactory(new BinaryCommandFactory());
        builder.setHealSessionInterval(5000);
        //获取连接池大小
        builder.setConnectionPoolSize(10);
        builder.setSessionLocator(new KetamaMemcachedSessionLocator());
        builder.getTranscoder().setCompressionThreshold(1024);

        MemcachedClient memcachedClient = builder.build();
        memcachedClient.setConnectTimeout(MemcachedClient.DEFAULT_CONNECT_TIMEOUT);
        memcachedClient.setOpTimeout(3000);
        // 清除所有缓存
        memcachedClient.flushAll();
        // 用完关闭连接
        memcachedClient.shutdown();
    }


}
