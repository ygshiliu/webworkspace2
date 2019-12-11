package com.wnn.bs.servlet;

import com.wnn.bs.bean.User;
import com.wnn.bs.service.UserService;
import com.wnn.bs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegeistServlet extends HttpServlet {

    private UserService us=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //封装成User对象
        User user = new User(null, username, password, email);

        //调用UserService,保存到数据库
        boolean flag = us.regist(user);

        //根据service层返回结果跳转页面
        if(flag){
            //成功重定向到页面
            response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
        }else{

            request.setAttribute("msg","此用户名已经注册过，请重新注册");
            //转发到注册页面，同时提示用户“此用户名已经注册过，请重新设置"
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

//            PrintWriter writer = response.getWriter();
//            writer.print("<!DOCTYPE html>");
//            writer.print("<html>");
//            writer.print("<head>");
//            writer.print(...);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
