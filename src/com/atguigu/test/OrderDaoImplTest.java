package com.atguigu.test;

import com.atguigu.dao.OrderDaoImpl;
import com.atguigu.dao.impl.OrderDao;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;


import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao od = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Order order = new Order("123456789", new Date(System.currentTimeMillis()), 0, new BigDecimal(33.1), 2);
        od.saveOrder(order);  }
        @Test
    public void queryOrders(){
            System.out.println( od.queryOrders() );
        }
        @Test
    public void changeOrderStatus(){
        od.changeOrderStatus("1632542379688userid2",1);
            System.out.println("开始发货");
        }
        @Test
    public void queryOrderByUserId(){
            System.out.println( od.queryOrderByUserId(2));
        }
}