package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItems;
import com.atguigu.service.BookService;
import com.atguigu.service.Impl.bookServiceImpl;
import com.atguigu.utils.webUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "cartServlet")
public class cartServlet extends baseServlet {
   BookService bs = new bookServiceImpl();
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要添加的item的id
        Integer id = webUtils.returnOn(request.getParameter("id"),0);
//        System.out.println("加入购物车");
        //通过id获取book相关信息 即要插入cart的items信息 作进一步转换
        Book book = bs.queryBookById(id);
        CartItems cartitem = new CartItems(book.getId(),1,book.getPrice(),book.getPrice(),book.getName());
        //通过session域中存储的信息来验证是否new一个 cart对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart==null){
            cart = new Cart();
        }
        cart.addItem(cartitem);
        request.getSession().setAttribute("cart",cart);
        String referer = request.getHeader("referer");
//        重定向
        response.sendRedirect(referer);
//        request.getSession().setAttribute("lastName", cartitem  );
//Map<String,Object> resultmap = new HashMap<>();
//resultmap.put("totalCount",cart.getTotalCount());
//resultmap.put("lastName",cartitem);
//Gson gson = new Gson();
//        String result = gson.toJson(resultmap);
//        response.getWriter().write(result);

    }
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = webUtils.returnOn(request.getParameter("id"),0);
        Cart cart  = (Cart)request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
            response.sendRedirect(request.getHeader("referer"));
        }

    }
    protected void clearItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart  = (Cart)request.getSession().getAttribute("cart");
        if(cart!=null){
        cart.clearItem();
            response.sendRedirect(request.getHeader("referer"));

        }
    }
    protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = webUtils.returnOn(request.getParameter("id"),0);
        int value = webUtils.returnOn(request.getParameter("value"),0);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if(cart!=null){
            cart.updateItem(id,value);
       response.sendRedirect(request.getHeader("referer"));
        }


    }


    }
