package com.yaojiafeng.test.aop;


/**
 * 被aop匹配到的类只要实现了非java.io.Serializable接口，就会默认做成jdk动态代理
 * 此时如果被匹配的方式不是实现接口的方法则无法被代理到
 *
 * @author yaojiafeng
 * @create 2017-12-14 下午2:34
 * @see com.yaojiafeng.test.aop.HelloServiceImpl#world
 */
public class HelloServiceImpl implements HelloService {

    public String hello() {
        return "hello";
    }

    /**
     * 被切面的方法，无法被代理，因为使用了jdk动态代理
     * @return
     */
    @LogMDC
    public String world() {
        return "world";
    }


}
