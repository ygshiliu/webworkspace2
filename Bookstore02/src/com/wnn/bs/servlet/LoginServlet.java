package com.wnn.bs.servlet;

import com.wnn.bs.bean.User;
import com.wnn.bs.service.UserService;
import com.wnn.bs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService us = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装成用户
        User user = new User(null, username, password, null);

        //调用service方法
        User dbUser = us.login(user);

        //根据返回结果跳转页面
        if(dbUser==null){
            //不成功回登录页面
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        }else{
            //成功去首页
            response.sendRedirect(request.getContextPath()+"/index.html");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
