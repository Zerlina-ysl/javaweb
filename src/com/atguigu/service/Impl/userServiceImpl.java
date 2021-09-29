package com.atguigu.service.Impl;

import com.atguigu.dao.impl.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class userServiceImpl implements UserService {
    @Override
    public User login(User user){
        UserDao dao = new UserDaoImpl();
        return dao.queryUsernameAndPassword(new User(null,user.getUsername(),user.getPassword(),null));

    }

    @Override
    public void register(User user) {
        UserDao dao = new UserDaoImpl();
        dao.saveUser(user);

    }

    @Override
    public boolean usernameifexists(String username) {
        UserDao dao = new UserDaoImpl();
        if( dao.queryUsername(username)==null ){
            return false;
        }
        return true;

    }
}
