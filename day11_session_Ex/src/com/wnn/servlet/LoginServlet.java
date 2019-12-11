package com.wnn.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        //获取请求参数
        String username = req.getParameter("username");

        //默认登录成功 。根据用户名到数据库中查询，获取用户信息
        //将用户信息设置到域: pagecontext request session(Y) application
        HttpSession session = req.getSession();
        session.setAttribute("username",username);

        //转发到页面
        req.getRequestDispatcher("index.jsp").forward(req,resp);


    }
}
