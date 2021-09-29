package com.atguigu.test;

import com.atguigu.dao.BookDaoImpl;
import com.atguigu.dao.impl.BookDao;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {
    private BookDao bd = new BookDaoImpl();//需要实例化一个对象
    @Test
    public void addBook() {
        bd.addBook(new Book(null,"晚熟的人",new BigDecimal(33.5),"莫言",100,100,null));

    }

    @Test
    public void deleteBook() {
bd.deleteBook(1);
    }

    @Test
    public void updateBook() {
        bd.updateBook(new Book(3,"男性凝视下的程序媛",new BigDecimal(68),"小李",99999,52,null));

    }

    @Test
    public void queryBookById() {
        System.out.println(bd.queryBookById(3));
    }

    @Test
    public void queryForList() {
        for (Book queryforlist : bd.queryForList()) {
            System.out.println(queryforlist);
        }
    }
    @Test
    public void querySingle(){
        System.out.println(bd.querySingle());
    }

    @Test
    public void queryForPageItems(){
        for(Book  book : bd.queryForPageItems(8,4)){
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageItemsByPrice(){
      for(Book book:bd.queryForPageItemsByPrice(10,4000,4,8)){
            System.out.println(book);
        }
    }
    @Test
    public void querySingleByPrice(){
        System.out.println(bd.querySingleByPrice(20,200));}
}