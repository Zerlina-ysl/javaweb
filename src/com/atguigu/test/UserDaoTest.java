package com.atguigu.test;

import com.atguigu.dao.impl.UserDao;
import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void queryUsername() {
        UserDao dao = new UserDaoImpl();
        if (dao.queryUsername("admin")==null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户已存在，请重试");
        }
    }

    @Test
    public void queryUsernameAndPassword() {
        UserDao dao = new UserDaoImpl();
        if (dao.queryUsernameAndPassword(new User(null,"admin","lsy123",null))==null ) {
            System.out.println("用户名或密码错误，请重试");
        }else{
            System.out.println("登录成功！");
        }
    }

    @Test
    public void saveUser() {
        UserDao dao = new UserDaoImpl();
        if( dao.saveUser(new User(null,"lishenyu","haha","lsy@qq.com"))==-1 ){
            System.out.println("注册失败，请重试");
        }else{
            System.out.println("注册成功");
        }
    }
}