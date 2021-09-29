package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.Impl.bookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class bookServiceImplTest {
BookService bd = new bookServiceImpl();
    @Test
    public void addBook() {

        bd.addBook(new Book(null,"什么时候才能学完",new BigDecimal(68),"小李",99999,52,null));
    }

    @Test
    public void deleteBook() {
        bd.deleteBook(22);
    }

    @Test
    public void updateBook() {
        bd.updateBook(new Book(21,"什么时候才能学完",new BigDecimal(68),"小李",99999,52,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bd.queryBookById(21));
    }

    @Test
    public void queryForList() {
        for(Book a:bd.queryForList()){
            System.out.println(a);
        }
    }
    @Test
    public void page(){
        System.out.println(bd.page(1,4));
    }

    @Test
    public void indexByPrice(){
        System.out.println(bd.indexByPrice(1,4,30,1000));}
}