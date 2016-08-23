/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.dao.repository;

import com.yaojiafeng.dao.entity.Order;

import java.util.List;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/23 下午2:30 $
 */
public interface OrderRepository {

    void insert(Order model);

    int update(List<Integer> userIds);

    int deleteAll();

    List<Order> selectAll();
}
