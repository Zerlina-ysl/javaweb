package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItems;
import com.sun.javaws.IconUtil;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.*;

public class CartTest {
Cart ca = new Cart();
    @Test
    public void addItem() {
        CartItems item = new CartItems(1,1,new BigDecimal(30),new   BigDecimal(30),"java程序入门");
        CartItems item2 = new CartItems(2,1,new BigDecimal(30),new   BigDecimal(30),"java程序深入浅出");
        CartItems item3 = new CartItems(2,1,new BigDecimal(30),new   BigDecimal(30),"java程序深入浅出");

        ca.addItem(item);
        ca.addItem(item2);
        ca.addItem(item3);
        System.out.println(ca);
    }
    @Test
    public void deleteItem(){
        CartItems item = new CartItems(3,1,new BigDecimal(30),new   BigDecimal(30),"java程序heh");
        ca.addItem(item);
        CartItems item4 = new CartItems(1,1,new BigDecimal(30),new   BigDecimal(30),"java程序入门");
        CartItems item2 = new CartItems(2,1,new BigDecimal(30),new   BigDecimal(30),"java程序深入浅出");
        CartItems item3 = new CartItems(2,1,new BigDecimal(30),new   BigDecimal(30),"java程序深入浅出");

        ca.addItem(item4);
        ca.addItem(item2);
        ca.addItem(item3);
        ca.deleteItem(1);
        System.out.println(ca);


    }
    @Test
    public void clearItem() {
        CartItems item = new CartItems(3, 1, new BigDecimal(30), new BigDecimal(30), "java程序heh");
        ca.addItem(item);
        CartItems item4 = new CartItems(1, 1, new BigDecimal(30), new BigDecimal(30), "java程序入门");
        CartItems item2 = new CartItems(2, 1, new BigDecimal(30), new BigDecimal(30), "java程序深入浅出");
        CartItems item3 = new CartItems(2, 1, new BigDecimal(30), new BigDecimal(30), "java程序深入浅出");

        ca.addItem(item4);
        ca.addItem(item2);
        ca.addItem(item3);
        ca.clearItem();
        System.out.println(ca);

    }
    @Test
    public void updateItem(){
        CartItems item = new CartItems(3, 1, new BigDecimal(30), new BigDecimal(30), "java程序heh");
        ca.addItem(item);
        CartItems item4 = new CartItems(1, 1, new BigDecimal(30), new BigDecimal(30), "java程序入门");
        CartItems item2 = new CartItems(2, 1, new BigDecimal(30), new BigDecimal(30), "java程序深入浅出");
        CartItems item3 = new CartItems(2, 1, new BigDecimal(30), new BigDecimal(30), "java程序深入浅出");

        ca.addItem(item4);
        ca.addItem(item2);
        ca.addItem(item3);
        ca.updateItem(1,0);
        System.out.println(ca);
    }
}