package com.atguigu.dao;

import com.atguigu.dao.impl.OrderDao;
import com.atguigu.dao.impl.OrderItemDao;
import com.atguigu.pojo.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public void saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(name,count,singlePrice,totalPrice,orderId)values(?,?,?,?,?)";
        update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getSinglePrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select id userId,name,count,singlePrice,totalPrice,orderId from t_order_item where orderId=?";
       return  queryForList(sql,OrderItem.class,orderId);
    }
}
