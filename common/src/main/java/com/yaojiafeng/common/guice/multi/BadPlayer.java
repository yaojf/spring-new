package com.yaojiafeng.common.guice.multi;

/**
 * Created by yaojiafeng on 2017/5/31 下午7:40.
 */
public class BadPlayer implements Player {
    public void bat() {
        System.out.println("I think i can face the ball");
    }

    public void bowl() {
        System.out.println("I dont know bowling");
    }
}
