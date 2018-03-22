package com.yaojiafeng.test.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yaojiafeng
 * @create 2017-12-28 上午11:03
 */
public class LogTest {

    @Test
    public void log() {
        Logger logger = LoggerFactory.getLogger(LogTest.class);
        LogUtils.printInfo(logger, "log1");
        LogUtils.printInfo(logger, "log2");
    }
}
