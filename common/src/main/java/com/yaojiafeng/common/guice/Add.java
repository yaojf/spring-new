package com.yaojiafeng.common.guice;

import com.google.inject.ImplementedBy;

/**
 * Created by yaojiafeng on 2017/5/31 下午5:24.
 */
@ImplementedBy(SimpleAdd.class)
public interface Add {
    int add(int a, int b);
}
