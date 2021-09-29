package com.atguigu.service;

import com.atguigu.pojo.User;
//一个业务一个方法
//对接业务层
public interface UserService {

    public User login(User user);

    /**
     * 注册
     * @param user
     * @return
     */
    public void register(User user);

    /**
     * 验证用户名是否存在
     * @param username
     * @return
     */

    public boolean usernameifexists(String username);






}
