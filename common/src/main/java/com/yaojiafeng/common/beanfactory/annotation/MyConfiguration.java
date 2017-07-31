package com.yaojiafeng.common.beanfactory.annotation;

import com.yaojiafeng.common.search.entity.Medicine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * 加不加Configuration都可以实现bean的注入，
 * 不加Configuration则会导致beanMethod内部调用@Bean注解的方法
 * 不再实行依赖注入，因为没有对工厂bean生成cglib动态代理，无法识别@Bean注解方法
 *
 * @author yaojiafeng
 * @create 2017-07-03 下午6:51
 */
@Configuration
public class MyConfiguration {


    @Bean(name = "medicine")
    public Medicine buildMedicine() {
        Medicine medicine = new Medicine(1, "1", string());
        return medicine;
    }

    @Bean(name = "string")
    public String string() {
        return new String("1");
    }

}
