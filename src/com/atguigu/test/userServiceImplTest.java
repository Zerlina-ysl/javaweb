package com.atguigu.test;

import com.atguigu.dao.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.Impl.userServiceImpl;
import com.atguigu.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class userServiceImplTest {

    @Test
    public void login() {
        UserService service = new userServiceImpl();
        if( service.login(new User(null,"admin","admin",null) )==null){
            System.out.println("登录失败");
        }else{
            System.out.println("登录成功");
        }
   }

    @Test
    public void register() {
        UserService service = new userServiceImpl();
        service.register(new User(null,"lsy","lsy666","lsy@qq.com"));


    }

    @Test
    public void  usernameifexists(){
        UserService service = new userServiceImpl();
        if( service.usernameifexists("lsy") )
        {
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名不存在");
        }
    }

}