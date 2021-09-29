package com.atguigu.dao.impl;

import com.atguigu.pojo.User;

public interface UserDao {
    /**
     * 注册时查看用户名是否有效
     * @param username
     * @return
     */
    public User queryUsername(String username);

    /**
     *
     * @param user
     * @return
     */
    public User queryUsernameAndPassword(User user);

    /**
     *
     * @param user
     * @return  注册用户
     */
    public int saveUser(User user);
}
