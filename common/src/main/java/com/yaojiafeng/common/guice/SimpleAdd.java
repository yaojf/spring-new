package com.yaojiafeng.common.guice;

/**
 * Created by yaojiafeng on 2017/5/31 下午5:25.
 */
public class SimpleAdd implements Add {
    public int add(int a, int b) {
        return a + b;
    }
}
