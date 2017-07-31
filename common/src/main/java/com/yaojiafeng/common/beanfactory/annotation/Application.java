package com.yaojiafeng.common.beanfactory.annotation;

import com.yaojiafeng.common.search.entity.Medicine;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yaojiafeng
 * @create 2017-07-03 下午6:44
 */
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        annotationConfigApplicationContext.register(MyConfiguration.class);
        annotationConfigApplicationContext.refresh();

        Medicine medicine = annotationConfigApplicationContext.getBean("medicine", Medicine.class);
        System.out.println(medicine.toString());

        Object myConfiguration = annotationConfigApplicationContext.getBean("myConfiguration");
        System.out.println(myConfiguration);

        Object string = annotationConfigApplicationContext.getBean("string");

        System.out.println(medicine.getFunction() == string);
    }
}
