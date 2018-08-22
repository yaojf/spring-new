package com.yaojiafeng.test.memcached;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by yaojiafeng on 2018/8/21 下午7:29.
 */
public class MemcachedTest {

    public static void main(String[] args) throws IOException, InterruptedException, MemcachedException, TimeoutException {
        Map<InetSocketAddress, AuthInfo> authInfoMap = new HashMap<InetSocketAddress, AuthInfo>();

        List<InetSocketAddress> addressList = new ArrayList<InetSocketAddress>();
        InetSocketAddress address = AddrUtil.getOneAddress("m-bp15ca9b090e59a4.memcache.rds.aliyuncs.com:11211");
        addressList.add(address);
        authInfoMap.put(address, AuthInfo.plain("m-bp15ca9b090e59a4", "Yangtuo228"));

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

        String tempKey = "sso_test_key_1";
        String tempVal = "sso_test_val_1";

        memcachedClient.set(tempKey, 60, tempVal);

        String val = memcachedClient.get(tempKey);

        System.out.println(val);

        memcachedClient.delete(tempKey);
    }
}
