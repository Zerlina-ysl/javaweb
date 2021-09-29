package com.atguigu.pojo;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
    private String orderId;
    private Date createDate;
    private int status=0;
    private BigDecimal price;
    private int userId;
public Order(){}

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createDate=" + createDate +
                ", status=" + status +
                ", price=" + price +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Order(String orderId, Date createDate, int status, BigDecimal price, int userId) {
        this.orderId = orderId;
        this.createDate = createDate;
        this.status = status;
        this.price = price;
        this.userId = userId;
    }
}
