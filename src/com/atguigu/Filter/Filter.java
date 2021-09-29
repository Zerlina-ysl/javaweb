package com.atguigu.Filter;

import com.atguigu.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Filter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpservletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpservletRequest.getSession();
        User user = (User)session.getAttribute("user");
        if(user==null){
            httpservletRequest.getRequestDispatcher("../user/login.jsp").forward(servletRequest,servletResponse);

        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
