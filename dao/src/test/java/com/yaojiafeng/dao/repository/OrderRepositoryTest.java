/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.yaojiafeng.dao.repository;

import com.yaojiafeng.dao.entity.Order;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * mock 可以对接口进行mock
 *
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 2017/1/16 上午10:59 $
 */
public class OrderRepositoryTest {

    OrderRepository orderRepository;
    Order order1;
    Order order2;

    {
        order1 = new Order();
        order1.setUserId(10);
        order1.setOrderId(1);
        order1.setStatus("INSERT");
        order2 = new Order();
        order2.setUserId(10);
        order2.setOrderId(2);
        order2.setStatus("INSERT");
    }

    @Before
    public void setUp() {
        orderRepository = mock(OrderRepository.class);

        when(orderRepository.selectAll()).thenReturn(Arrays.asList(order1, order2));
        when(orderRepository.selectByOrderId(1)).thenReturn(order1);
        when(orderRepository.insert(order1)).thenReturn(1);
        when(orderRepository.update(Arrays.asList(10))).thenReturn(1);
    }

    @Test
    public void testSelectAll() throws Exception {
        List<Order> orders = orderRepository.selectAll();
        assertEquals(2, orders.size());
        Order order1 = orders.get(0);
        assertEquals(10, order1.getUserId());
        assertEquals(1, order1.getOrderId());
        assertEquals("INSERT", order1.getStatus());
    }

    @Test
    public void testSelectByOrderId() {
        Order order = orderRepository.selectByOrderId(1);
        assertEquals(order.getUserId(), 10);
    }

    @Test
    public void testInsert() {
        int insert = orderRepository.insert(order1);
        assertEquals(insert, 1);
    }

    @Test
    public void testUpdate() {
        int update = orderRepository.update(Arrays.asList(10));
        assertEquals(update, 1);
    }
}
