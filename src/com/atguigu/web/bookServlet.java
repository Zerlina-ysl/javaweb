package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.Impl.bookServiceImpl;
import com.atguigu.utils.webUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class bookServlet extends baseServlet{
private BookService bd = new bookServiceImpl();
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),0)+1;
         Book book  = webUtils.copyparamToBean(request.getParameterMap(), new Book());
         //获取参数 所以添加数据要用表单记录，action地址为此Servlet地址
        bd.addBook(book);
//        request.getRequestDispatcher("/manager/bookServlet?action=query").forward(request,response);不需要进行转型
//        不能用转发，刷新浏览器会再次进行最后一次请求          重定向
response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),0);
//        bd.deleteBook(new Integer(request.getParameter("id")));需要抛异常 干脆写成函数复用
        Integer id = webUtils.returnOn(request.getParameter("id"), 0);
        bd.deleteBook(id);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);


    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),0);
        Book book = webUtils.copyparamToBean(request.getParameterMap(), new Book());
        bd.updateBook(book);
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = webUtils.returnOn(request.getParameter("id"),0);
        Book book = bd.queryBookById(id);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo="+request.getParameter("pageNo")).forward(request,response);

    }

        protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //通过BookService获取所有图书信息
            List<Book> bookList =  bd.queryForList();
            //将图书信息保存在request域
            request.setAttribute("books",bookList);
            //请求转发到 /pages/manager/book,jsp页面
            request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理分页业务
        //获取参数pegeNo 和 pageSize
        Integer pageNo = webUtils.returnOn(request.getParameter("pageNo"),1);
        //设置数据的边界值
        Integer pageSize = webUtils.returnOn(request.getParameter("pageSize"), Page.PAGESIZE);
        //调用bookService的page方法：获取page对象
        Page<Book> page = bd.page(pageNo, pageSize);

        page.setUrl("manager/bookServlet?action=page");
        //保存page对象到request域
    request.setAttribute("page",page);
        //请求转发到页面
request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);


    }
    }
