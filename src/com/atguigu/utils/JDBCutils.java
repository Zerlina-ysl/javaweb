package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.ha.selector.DataSourceSelectorFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutils {

    public static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {

        try {
            Properties properties = new Properties();
            InputStream is = JDBCutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
//        Connection conn = null;
//
//        try {
//            conn = dataSource.getConnection();
//
//        } catch (Exception throwables) {
//            throwables.printStackTrace();
//        }
//        return conn;

        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = dataSource.getConnection();
                conns.set(conn);//保存在ThreadLocal中
                conn.setAutoCommit(false);
                //使用ThreadLocal 确保取出同一个conn 即使用同一个COnnection链接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void commitAndclose(){
    Connection connection = conns.get();
    if(connection!=null)
    {
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    //Tomcat服务器底层使用线程池技术
    conns.remove();
        }

        public static void rollbackAndclose(){
            Connection connection = conns.get();
            if(connection!=null)
            {
                try {
                    connection.rollback();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }finally{
                    try {
                        connection.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
            //Tomcat服务器底层使用线程池技术
            conns.remove();
        }

}

//    public static void close(Connection conn){
//        if(conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//    }

