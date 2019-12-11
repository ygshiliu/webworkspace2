package com.wnn.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 问题：servlet中的大部分抽象方法没有用上，但是还要必须实现
*
*
* */

public class firstServlet implements Servlet {
    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        //System.out.println("hello,server!");

        Object gender = servletRequest.getAttribute("gender");
        System.out.println("gender:"+gender);

        final String username = servletRequest.getParameter("username");
        final String password = servletRequest.getParameter("password");
        System.out.println(username + "---"+password);

        //返回信息
        final PrintWriter writer = servletResponse.getWriter();
//        writer.println("hello,client");
        writer.println("客户端");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
