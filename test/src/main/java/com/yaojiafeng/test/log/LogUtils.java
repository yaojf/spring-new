package com.yaojiafeng.test.log;

import org.slf4j.Logger;

/**
 * @author yaojiafeng
 * @create 2017-12-28 上午11:04
 */
public class LogUtils {

    /**
     * 这种使用工具类打印会丢失原来代码的打印行数
     * @param logger
     * @param msg
     */
    public static void printInfo(Logger logger, String msg) {
        logger.info(msg);
    }

}
