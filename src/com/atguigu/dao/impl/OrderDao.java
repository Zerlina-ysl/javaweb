package com.atguigu.dao.impl;

import com.atguigu.pojo.Order;

import java.util.List;

public interface OrderDao {
    //添加一条订单
    public void saveOrder(Order order);

    public List<Order> queryOrders();

    public void changeOrderStatus(String orderId,int status);

    public  List<Order> queryOrderByUserId(int userId);
}
