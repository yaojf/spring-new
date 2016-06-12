/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.common.beanfactory;

import com.yaojiafeng.common.util.ApplicationUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/5/2 下午3:43 $
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-common.xml");

        System.out.println(2);
        ApplicationUtils velocityEngine = (ApplicationUtils) context.getBean(ApplicationUtils.class);

        System.out.println(3);
    }
}
