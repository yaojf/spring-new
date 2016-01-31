package com.yaojiafeng.common.util;

/**
 * Created by yaojiafeng on 16/1/29.
 */
public abstract class BeanUtils {


    public static void copy(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }


}
