package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    public  Page<Book> page(Integer pageNo, Integer pageSize) ;

    public void  addBook(Book book);

    public void deleteBook(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryForList();

    public Page<Book> indexByPrice(Integer pageNo, Integer pageSize,int min, int max);
}
