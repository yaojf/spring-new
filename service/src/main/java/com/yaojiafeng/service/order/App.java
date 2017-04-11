package com.yaojiafeng.service.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/23 下午2:40 $
 */
public class App {
    public static void main(final String[] args) {
        // CHECKSTYLE:ON
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-datasource.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.clear();
        orderService.fooService();
        orderService.select();

        //[order_id: 1, user_id: 10, status: UPDATED, order_id: 1, user_id: 11, status: UPDATED]
        orderService.clear();
        try {
            orderService.fooServiceWithFailure();
        } catch (final IllegalArgumentException e) {
            System.out.println("roll back");
        }
        //[]
        orderService.select();
    }
}
