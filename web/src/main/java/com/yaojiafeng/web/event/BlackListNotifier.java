package com.yaojiafeng.web.event;

import org.springframework.context.ApplicationListener;

/**
 * Created by yaojiafeng on 16/1/27.
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    public void onApplicationEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(event.getAddress()+","+event.getTest());

    }

}
