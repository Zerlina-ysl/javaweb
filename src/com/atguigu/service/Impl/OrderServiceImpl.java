package com.atguigu.service.Impl;

import com.atguigu.dao.BookDaoImpl;
import com.atguigu.dao.OrderDaoImpl;
import com.atguigu.dao.OrderItemDaoImpl;
import com.atguigu.dao.impl.BookDao;
import com.atguigu.dao.impl.OrderDao;
import com.atguigu.dao.impl.OrderItemDao;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.lang.management.BufferPoolMXBean;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
   OrderItemDao oid = new OrderItemDaoImpl();
   OrderDao od = new OrderDaoImpl();
BookDao bd = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, int userId) {
        String orderId = System.currentTimeMillis() + "userid"+userId;//订单编号
        Order order = new Order(orderId,new Date(System.currentTimeMillis()),0,cart.getTotalPrice(),userId);
        od.saveOrder(order);//保存订单
//对于购物车里面的所有订单Cart 取出每一个订单的信息
        int i = 12/0;//test
        for(Map.Entry<Integer, CartItems> entry:cart.getItems().entrySet()){
            //遍历Cart类 找到HashMap Items里面的对应 订单详情项目的属性值
            CartItems cartItems  = entry.getValue();
            OrderItem orderItem = new OrderItem(orderId,userId,cartItems.getName(),cartItems.getCount(),cartItems.getSingleprice(),cartItems.getTotalPrice());
            oid.saveOrderItem(orderItem);
            Book book = bd.queryBookById(cartItems.getId());
            book.setSales(book.getSales()+cartItems.getCount());
            book.setStock(book.getStock()-cartItems.getCount());
            bd.updateBook(book);
        }
        //创建新的订单 删除购物车里的项目

        cart.clearItem();
        return orderId;
    }

    @Override
    /**
     * 查询所有订单信息
     */
    public List<Order> queryOrders() {
       return  od.queryOrders();
    }

    /**
     * 修改发货状态   未发货-》已发货
     * @param orderId
     */
    @Override
    public void sendOrder(String orderId) {
        od.changeOrderStatus(orderId,1);
    }

    /**
     * x修改发货状态 签收订单
     * @param orderId
     */
    public void receiverOrder(String orderId){
        od.changeOrderStatus(orderId,2);
    }

    @Override
    public List<Order> showMyOrders(int userId) {
        return od.queryOrderByUserId(userId);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) {
        return oid.queryOrderItemsByOrderId(orderId);
    }
}
