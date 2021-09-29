package com.atguigu.pojo;

import java.math.BigDecimal;

public class CartItems {
    private Integer id;
    private Integer count;
    private  BigDecimal singleprice;
    private BigDecimal totalPrice;
    private  String name;

    public CartItems() {

    }

    public CartItems(Integer id, Integer count, BigDecimal singleprice, BigDecimal totalPrice, String name) {
        this.id = id;
        this.count = count;
        this.singleprice = singleprice;
        this.totalPrice = totalPrice;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "id=" + id +
                ", count=" + count +
                ", singleprice=" + singleprice +
                ", totalPrice=" + totalPrice +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getSingleprice() {
        return singleprice;
    }

    public void setSingleprice(BigDecimal singleprice) {
        this.singleprice = singleprice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
