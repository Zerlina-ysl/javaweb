package com.atguigu.utils;
//对于参数键值对的直接注入
import com.atguigu.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class webUtils {
    /**
     * 直接获取map键值对值注入：dao、service、web 耦合度低、扩展性高
     * @param value
     * @param bean
     */
//    public static void copyparamToBean(HttpServletRequest request, T bean) {
    public static <T>T  copyparamToBean(Map value , T bean) {
    try {
            //把所有请求的参数（Ma)注入user对象(Javabean)中
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return bean;
    }

    public static int returnOn(String value,Integer defaultValue){

        try {
            if(value!=null) {
                return Integer.parseInt(value);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
    }
        return defaultValue;


    }

}