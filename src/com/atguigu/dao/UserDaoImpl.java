package com.atguigu.dao;

import com.atguigu.dao.impl.UserDao;
import com.atguigu.pojo.User;

public class UserDaoImpl extends BaseDao implements UserDao {
    /**
     *
     * @param username
     * @return  查询失败返回null
     */
    @Override
    public User queryUsername(String username) {
        String sql = "select id,username,password,email from t_user where username=?";
        return queryForOne(sql,User.class,username);
    }


    /**
     *
     * @param user
     * @return
     */
    @Override
    public User queryUsernameAndPassword(User user) {
        String sql = "select id,username,password,email from t_user where username=? and password=?";
        return queryForOne(sql,User.class,user.getUsername(),user.getPassword());
    }

    /**
     *
     * @param user
     * @return  注册失败返回-1
     */
    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email)values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());

    }
}
