package com.atguigu.dao;

import com.atguigu.utils.JDBCutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {

    /**
     *
     * @param sql
     * @param args
     * @return 操作成功返回行数，失败返回-1
     */

    public int update(String sql,Object ...args){
        Connection conn=null;
        try {
            conn = JDBCutils.getConnection();
            QueryRunner run = new QueryRunner();
            return run.update(conn,sql,args);
        } catch (Exception e) {
            e.printStackTrace();
    throw new RuntimeException(e);

    }}

    /**
     *
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return  操作失败返回空值，成功返回查询结果
     */
    public<T> T queryForOne(String sql,Class<T> type,Object ...args){
        Connection conn = JDBCutils.getConnection();
        QueryRunner run = new QueryRunner();
        try {
            return run.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
           throw new RuntimeException(e);

    }}

    /**
     *
     * @param sql
     * @param type
     * @param args
     * @param <T>
     * @return  操作失败返回空值，成功返回查询结果
     */
    public<T> List<T> queryForList(String sql, Class<T> type, Object ...args){
        Connection conn = JDBCutils.getConnection();
        try {
        QueryRunner run = new QueryRunner();
            return run.query(conn,sql,new BeanListHandler<T>(type),args);
            //负责把ResultSet第一行结果转换成一个JavaBean
        } catch (Exception e) {
            throw new RuntimeException(e);}


    }

    public Object queryForSingleValue(String sql,Object ...args){
        Connection conn = JDBCutils.getConnection();
        QueryRunner run = new QueryRunner();
        try {
            return run.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
throw new RuntimeException(e);//要抛出异常
    }}



}
