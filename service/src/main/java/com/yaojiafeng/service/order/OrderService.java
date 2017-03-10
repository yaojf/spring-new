/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.service.order;

import com.google.common.collect.Lists;
import com.yaojiafeng.dao.entity.Order;
import com.yaojiafeng.dao.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/8/23 下午2:33 $
 */
@Service
//@Transactional
public class OrderService {

    @Resource
    private OrderRepository orderRepository;

//    @Transactional(readOnly = true)
    public void select() {
        System.out.println(orderRepository.selectAll());
    }

    public void clear() {
        orderRepository.deleteAll();
    }

    public void fooService() {
        Order criteria = new Order();
        criteria.setUserId(10);
        criteria.setOrderId(1);
        criteria.setStatus("INSERT");
        orderRepository.insert(criteria);
        criteria.setUserId(11);
        criteria.setOrderId(1);
        criteria.setStatus("INSERT2");
        orderRepository.insert(criteria);
        orderRepository.update(Lists.newArrayList(10, 11));
    }

    public void fooServiceWithFailure() {
        fooService();
        throw new IllegalArgumentException("failed");
    }
}