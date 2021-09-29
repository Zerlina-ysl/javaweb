package com.atguigu.test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItems;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.BookService;
import com.atguigu.service.Impl.OrderServiceImpl;
import com.atguigu.service.Impl.bookServiceImpl;
import com.atguigu.service.OrderService;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
OrderService os = new OrderServiceImpl();
Cart ca = new Cart();
BookService bs = new bookServiceImpl();
    @Test
    public void createOrder() {
        Book book = bs.queryBookById(32);

        CartItems item = new CartItems(book.getId(),1,book.getPrice(),book.getPrice(),book.getName());
        ca.addItem(item);
        System.out.println( os.createOrder(ca,2)  );
    }

    @Test
    public void queryOrders(){
        Book book = bs.queryBookById(32);

        CartItems item = new CartItems(book.getId(),1,book.getPrice(),book.getPrice(),book.getName());
        ca.addItem(item);
        os.createOrder(ca,2);
        System.out.println( os.queryOrders());
    }
    @Test
    public void sendOrder(){
    os.sendOrder("1632542379688userid2");
        System.out.println("发货成功");
    }
    @Test
    public void receiverOrder(){
os.receiverOrder("1632542379688userid2");
        System.out.println("签收成功");
    }

    @Test
    public void queryOrderByUserId(){
        System.out.println( os.showMyOrders(2));
    }
    @Test
    public void  showOrderDetail() {
        System.out.println(os.showOrderDetail("1632542736910userid2"));



    }
    }