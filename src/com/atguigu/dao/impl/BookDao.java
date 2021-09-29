package com.atguigu.dao.impl;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    public int  addBook(Book book);

    public int deleteBook(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryForList();


    public Integer querySingle();

    public Integer querySingleByPrice(int min,int max);


   public  List<Book> queryForPageItems(Integer begin, Integer pageSize);

    List<Book> queryForPageItemsByPrice(int min, int max, Integer begin, Integer pageSize);
}
