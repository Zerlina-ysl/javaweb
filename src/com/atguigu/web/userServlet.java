package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.Impl.userServiceImpl;
import com.atguigu.service.UserService;
import com.atguigu.utils.webUtils;
import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

@WebServlet(name = "userServlet")
public class userServlet extends baseServlet {
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清楚session
        request.getSession().invalidate();
        response.sendRedirect("pages/client/index.jsp");

    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除验证码 若回退 为null验证
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        UserService service = new userServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String email = request.getParameter("email");
        String code = request.getParameter("code");
//        User user = new User();
//        webUtils.copyparamToBean(request.getParameterMap(),user);
        User user = webUtils.copyparamToBean(request.getParameterMap(), new User());//--->>>>使用泛型,可以避免强转


//        for(Map.Entry<String,String[]> entry:parameterMap.entrySet() ){
//            System.out.println(entry.getKey()+"=="+ Arrays.asList(entry.getKey()));
//        }//根据set方法注入属性值
        if (token == null || !(token.equalsIgnoreCase(code))) {
            request.setAttribute("errormsg", "验证码错误");
            request.setAttribute("email", email);
            request.setAttribute("username", username);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            System.out.println("验证码错误");
        } else if (service.usernameifexists(username)) {
            request.setAttribute("errormsg", "用户名已存在");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            System.out.println("用户名已存在");
        } else {
            service.register(new User(null, username, password, email));
            request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new userServiceImpl();
        User userlogin = service.login(new User(null, username, password, null));
        if (userlogin == null) {
            request.setAttribute("errormsg", "用户名或密码错误");
            request.setAttribute("username", username);//回写username
            request.getRequestDispatcher("pages/user/login.jsp").forward(request, response);
//            System.out.println("用户名或密码错误");
        } else {
            request.getRequestDispatcher("pages/user/login_success.jsp").forward(request, response);
            request.getSession().setAttribute("user", userlogin);
        }
    }

    protected void ajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //使用ajax获取到前端参数，封装成为hashmap=>json对象传递给后端
        String username = request.getParameter("username");
        UserService us = new userServiceImpl();
        boolean result = us.usernameifexists(username);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("existusername", result);
        Gson gson = new Gson();
        String mapstring = gson.toJson(map);
        response.getWriter().write(mapstring);


    }
}