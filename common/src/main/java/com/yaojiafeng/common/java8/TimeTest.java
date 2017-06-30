package com.yaojiafeng.common.java8;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author yaojiafeng
 * @create 2017-06-29 上午11:19
 */
public class TimeTest {

    public static void main(String[] args) {
        OffsetDateTime offsetDateTime = Instant.now().atOffset(ZoneOffset.ofHours(8));// 获取北京时间
        System.out.println(offsetDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(offsetDateTime));
    }

}
