package com.yaojiafeng.common.guice;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Created by yaojiafeng on 2017/5/31 下午5:25.
 */
public class AddModule implements Module{

    public void configure(Binder binder) {
        binder.bind(Add.class).to(SimpleAdd.class);
    }
}
