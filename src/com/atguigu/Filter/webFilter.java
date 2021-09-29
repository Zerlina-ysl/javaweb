package com.atguigu.Filter;

import com.atguigu.utils.JDBCutils;

import javax.servlet.*;
import javax.servlet.Filter;
import java.io.IOException;

public class webFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JDBCutils.commitAndclose();
        } catch (Exception e) {
            JDBCutils.rollbackAndclose();
            e.printStackTrace();
            throw new RuntimeException(e);//需要抛出异常
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
