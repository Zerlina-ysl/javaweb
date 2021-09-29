package com.atguigu.web;

import com.atguigu.dao.BaseDao;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.User;
import com.atguigu.service.Impl.OrderServiceImpl;
import com.atguigu.service.OrderService;
import com.atguigu.utils.JDBCutils;
import com.atguigu.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderServlet")
public class orderServlet extends baseServlet {
    OrderService os = new OrderServiceImpl();
    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        User user = (User)request.getSession().getAttribute("user");
//用户未登陆时，user为null
     if(user==null){
         request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        return ;
     }
        if(cart==null){
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return;

        }
            Integer userId = webUtils.returnOn(user.getId(),0);
        String  orderId = os.createOrder(cart,userId);


        request.getSession().setAttribute("orderId",orderId);

//    request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request,response)重定向无法共享request域
    response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
    protected void queryOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //pages/order/order_manager.jsp
        List<Order>  orders = os.queryOrders();
        request.getSession().setAttribute("order",orders);
        response.sendRedirect(request.getContextPath()+"/pages/manager/order_manager.jsp");

    }
    protected void queryMyOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
            return ;
        }
        Integer userId = webUtils.returnOn(user.getId(),0);
        List<Order>  orders = os.showMyOrders(userId);

        request.getSession().setAttribute("order",orders);
        response.sendRedirect(request.getContextPath()+"/pages/order/order.jsp");

    }
    protected void sendOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String orderId = request.getParameter("orderId");

            os.sendOrder(orderId);
        response.sendRedirect(request.getContextPath()+"/pages/manager/order_manager.jsp");


    }

    }
