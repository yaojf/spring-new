package com.yaojiafeng.web.config;

import com.yaojiafeng.web.event.BlackListEvent;
import org.springframework.context.annotation.*;

/**
 * Created by yaojiafeng on 16/1/26.
 */
@Configuration
public class AppConfig {

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public BlackListEvent blackListEvent() {
        return new BlackListEvent(this, null, null);
    }

}
