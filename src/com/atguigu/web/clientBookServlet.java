package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.Impl.bookServiceImpl;
import com.atguigu.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "clientBookServlet")
public class clientBookServlet extends baseServlet {
    BookService bd = new bookServiceImpl();
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理分页业务
        //获取参数pegeNo 和 pageSize
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),1);
        //设置数据的边界值
        Integer pageSize = webUtils.returnOn(request.getParameter("pageSize"), Page.PAGESIZE);
        //调用bookService的page方法：获取page对象
        Page<Book> page = bd.page(pageNo, pageSize);
        page.setUrl("manager/clientBookServlet?action=page");
        //保存page对象到request域
        request.setAttribute("page",page);
        //请求转发到页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);


    }
    protected void indexByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int min = webUtils.returnOn(request.getParameter("min"),0);
    int max = webUtils.returnOn(request.getParameter("max"),Integer.MAX_VALUE);  //获取参数pegeNo 和 pageSize
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),1);
        //设置数据的边界值
        Integer pageSize = webUtils.returnOn(request.getParameter("pageSize"), Page.PAGESIZE);
        //调用bookService的page方法：获取page对象
        Page<Book> page = bd.indexByPrice(pageNo,pageSize,min,max);
//分页条的请求地址需要带着min和max
        page.setUrl("manager/clientBookServlet?action=indexByPrice&min="+min+"&max="+max);
//        StringBuilder sb = new StringBuilder("manager/clientBookServlet?action=indexByPrice");
//        if(request.getParameter("min")!=null){
//            sb.append("&min=").append(request.getParameter("min"));
//        }
//        if(request.getParameter("max")!=null){
//            sb.append("&max=").append(request.getParameter("max"));
//        }
//        page.setUrl(sb.toString());设置了数据边界欸，所以我觉得没有这么麻烦
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);





    }
    }
