package com.yaojiafeng.common.util;

import org.slf4j.Logger;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/3/23 下午5:53 $
 */
public class LogUtils {

    public static void info(Logger logger, String message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    public static void error(Logger logger, String message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }
}
