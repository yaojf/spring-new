package com.yaojiafeng.test.EventBus;

/**
 * @author yaojiafeng
 * @create 2017-09-18 上午11:31
 */
public class OrderEvent {
    private String message;

    public OrderEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
