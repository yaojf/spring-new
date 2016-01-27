package com.yaojiafeng.web.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by yaojiafeng on 16/1/27.
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }

    // accessor and other methods...

    public String getAddress() {
        return address;
    }

    public String getTest() {
        return test;
    }
}
