package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,int userId);

    public List<Order> queryOrders();

    public void sendOrder(String orderId);

    public void receiverOrder(String orderId);

        public List<Order> showMyOrders(int userId);

        public  List<OrderItem> showOrderDetail(String orderId);
}
