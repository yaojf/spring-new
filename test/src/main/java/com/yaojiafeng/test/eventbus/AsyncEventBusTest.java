package com.yaojiafeng.test.eventbus;

import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

/**
 * 异步事件总线
 *
 *
 * Created by yaojiafeng on 2018/9/7 下午2:33.
 */
public class AsyncEventBusTest {

    public static void main(String[] args) {
        AsyncEventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(1), (ex, context) ->
                System.err.printf("EventBusError,post event exception, event=%s, handler=%s, exception=%s", context.getEvent(), context.getSubscriber(), ex));

        //register all subscriber
        asyncEventBus.register(new HelloEventListener());

        //publish event
        asyncEventBus.post(new OrderEvent("hello"));
        asyncEventBus.post(new OrderEvent("world"));
    }

}
