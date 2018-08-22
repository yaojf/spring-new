package com.yaojiafeng.test.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @author yaojiafeng
 * @create 2017-09-18 上午11:32
 */
public class Starter {

    public static void main(String[] args) {

        EventBus eventBus = new EventBus("ricky");

        //register all subscriber
        eventBus.register(new HelloEventListener());

        //publish event
        eventBus.post(new OrderEvent("hello"));
        eventBus.post(new OrderEvent("world"));
    }
}
