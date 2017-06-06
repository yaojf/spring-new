package com.yaojiafeng.common.classloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 类加载是惰性的，所有依赖的类，也是惰性加载的
 *
 * Created by yaojiafeng on 2017/6/6 下午7:03.
 */
public class ClassLoaders {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        URL[] urls = {new URL("file:///data/html/caches/superopenapi/parse/knife-1.0.9.jar")};

        URLClassLoader urlClassLoader1 = new URLClassLoader(urls, System.class.getClassLoader());

        URLClassLoader urlClassLoader2 = new URLClassLoader(urls, System.class.getClassLoader());

        Class<?> clazz1 = urlClassLoader1.loadClass("com.qccr.knife.result.Results");

        Class<?> clazz2 = urlClassLoader2.loadClass("com.qccr.knife.result.Results");

        /**
         * 不是同一个类，类装载器不同
         */
        System.out.println(clazz1 == clazz2);
    }
}
