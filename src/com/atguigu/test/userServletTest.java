package com.atguigu.test;

import java.lang.reflect.Method;

//反射应用的测试
public class userServletTest {
    public void login(){
        System.out.println("调用了login()方法");
    }
    public void regist(){
        System.out.println("调用了login()方法");
    }

    public void updateUser(){
        System.out.println("调用了login()方法");
    }

    public static void main(String[] args) {
        String action = "login";
        try {
            Method method = userServletTest.class.getDeclaredMethod(action);
            method.invoke(new userServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
