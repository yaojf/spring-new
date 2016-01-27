package com.yaojiafeng.web.processor;

import com.yaojiafeng.web.event.EmailService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by yaojiafeng on 16/1/27.
 * <p/>
 * bean后置处理器
 */
public class PropertiesBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof EmailService) {
            System.out.println(((EmailService)bean));
        }

        return bean;
    }
}
