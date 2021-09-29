package com.atguigu.dao;

import com.atguigu.dao.impl.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.utils.JDBCutils;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override

    public void saveOrder(Order order) {
        String sql = "insert into t_order(createTime,price,status,orderId,userId) values (?,?,?,?,?)";
        update(sql,order.getCreateDate(),order.getPrice(),order.getStatus(),order.getOrderId(),order.getUserId());
    }

    @Override
    public List<Order> queryOrders() {
        String sql = "select createTime createDate,price,status,orderId,userId from t_order";
        return queryForList(sql,Order.class);
    }

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     */

    @Override
    public void changeOrderStatus(String orderId, int status) {
        String sql = "update t_order set status = ? where orderId = ?";

        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(int userId) {
        String sql = "select  createTime createDate,price,status,orderId,userId from t_order where userId = ?";
        return queryForList(sql,Order.class,userId);
    }
}
