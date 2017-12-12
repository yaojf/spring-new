package com.yaojiafeng.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: yaojiafeng
 * Date: 15/7/30
 * Time: 下午2:15
 */
public class DateUtils {

    public static String now() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
