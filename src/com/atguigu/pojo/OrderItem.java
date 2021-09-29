package com.atguigu.pojo;

import java.math.BigDecimal;

public class OrderItem {
    private String orderId;
    private int userId;
    private String name;
    private int count;
    private BigDecimal singlePrice;
    private BigDecimal totalPrice;

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", singlePrice=" + singlePrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(BigDecimal singlePrice) {
        this.singlePrice = singlePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderItem(){
    }

    public OrderItem(String orderId, int userId, String name, int count, BigDecimal singlePrice, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.userId = userId;
        this.name = name;
        this.count = count;
        this.singlePrice = singlePrice;
        this.totalPrice = totalPrice;
    }
}
