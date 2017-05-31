package com.yaojiafeng.common.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by yaojiafeng on 2017/5/31 下午3:54.
 */
public class Guices {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AddModule());
        Add add = injector.getInstance(Add.class);
        System.out.println(add.add(10, 54));

        AddClient addClient = injector.getInstance(AddClient.class);
        System.out.println(addClient.add(1, 2));


    }

}
