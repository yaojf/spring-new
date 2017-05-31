package com.yaojiafeng.common.guice.multi;

/**
 * Created by yaojiafeng on 2017/5/31 下午7:40.
 */
public class GoodPlayer implements Player {
    public void bat() {
        System.out.println("I can hit any ball");
    }

    public void bowl() {
        System.out.println("I can also bowl");
    }
}
