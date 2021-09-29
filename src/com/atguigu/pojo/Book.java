package com.atguigu.pojo;

import java.math.BigDecimal;

public class Book {
    private Integer id;
    private String name;
    private BigDecimal price;
    private String author;
    private Integer stock;
    private Integer sales;
    private String imgpath = "static/img/default.jpg";
    public Book(){

    }
    public Book(Integer id, String name, BigDecimal price, String author, Integer stock, Integer sales, String imgpath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.stock = stock;
        this.sales = sales;
        this.imgpath = "static/img/default.jpg";
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", stock=" + stock +
                ", sales=" + sales +
                ", imgpath='" + imgpath + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
