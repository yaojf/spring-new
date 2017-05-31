package com.yaojiafeng.common.guice;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by yaojiafeng on 2017/5/31 下午5:53.
 */
@Singleton
public class AddClient {

    private Add add;

    @Inject
    public AddClient(Add add) {
        this.add = add;
    }

    public int add(int a, int b) {
        return add.add(a, b);
    }


}
