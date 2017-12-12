package com.yaojiafeng.test.stream;

import lombok.Data;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yaojiafeng
 * @create 2017-08-01 上午11:30
 */
public class StreamTest {

    @Test
    public void testStream() {
//        List<Long> list = new ArrayList<>();
//        list.add(1L);
//        list.add(2L);
//        String nextHandlerStr = getNextHandlerStr(list);
//        System.out.println(nextHandlerStr);
        String s="1600";

        BigDecimal divide = new BigDecimal("1600").divide(new BigDecimal("1000000"));
        System.out.println(divide.toString());

    }

    public String getNextHandlerStr(List<Long> nextHandler) {
        String collect = nextHandler.stream().map(tmp -> tmp.toString()).collect(Collectors.joining(","));
        return collect;
    }
}
