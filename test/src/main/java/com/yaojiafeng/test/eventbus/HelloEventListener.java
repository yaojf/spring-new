package com.yaojiafeng.test.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * @author yaojiafeng
 * @create 2017-09-18 上午11:31
 */
public class HelloEventListener {

    @Subscribe
    public void listen(OrderEvent event) {
        System.out.println("receive msg:" + event.getMessage());
    }
}
