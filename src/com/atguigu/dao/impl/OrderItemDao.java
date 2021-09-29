package com.atguigu.dao.impl;

import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderItemDao {
    //添加一条订单的详情信息
    public void saveOrderItem(OrderItem orderItem);

    public List<OrderItem> queryOrderItemsByOrderId(String orderId);
}
