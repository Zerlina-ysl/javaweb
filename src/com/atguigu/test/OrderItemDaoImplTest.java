package com.atguigu.test;

import com.atguigu.dao.OrderItemDaoImpl;
import com.atguigu.dao.impl.OrderItemDao;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {
OrderItemDao oid = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        oid.saveOrderItem(new OrderItem("123456789",2,"java从入门到放弃",1,new BigDecimal(33.1),new BigDecimal(33.1)));
        System.out.println("订单详情信息已加载");
    }
    @Test
    public void queryOrderItemsByOrderId(){
        System.out.println(   oid.queryOrderItemsByOrderId("1632542736910userid2")    );
    }
}