package com.yaojiafeng.dao.sqlite;

import java.sql.Connection;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/7/22 上午11:29 $
 */
@FunctionalInterface
public interface CallBack<T> {
    T doCallBack(Connection connection) throws Exception;
}
