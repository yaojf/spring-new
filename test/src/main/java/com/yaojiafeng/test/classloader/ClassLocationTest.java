package com.yaojiafeng.test.classloader;

import java.security.CodeSource;

/**
 * Created by yaojiafeng on 2018/10/25 下午3:23.
 */
public class ClassLocationTest {

    public static void main(String[] args) {
        String className = "net.rubyeye.xmemcached.MemcachedClientBuilder";

        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (Exception e) {

        }
        if (clazz == null) {
            System.out.println(className + "not found");
        } else {
            CodeSource codeSource = clazz.getProtectionDomain().getCodeSource();
            if (codeSource == null) {
                System.out.println(className + " location not available");
            } else {
                String location = codeSource.getLocation().getPath();
                System.out.println(className + " location: " + location + " classLoader: " + clazz.getClassLoader());
            }
        }

        try {
            Class<?> clazz2 = Class.forName(className);
            System.out.println(clazz2 == clazz);
        } catch (Exception e) {

        }

    }
}
