package com.yaojiafeng.test.serial;

import java.io.Serializable;

/**
 * Created by yaojiafeng on 2019/1/2 10:45 AM.
 */
public class CouponTO implements Serializable {

    private static final long serialVersionUID = 8115946851215803378L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
