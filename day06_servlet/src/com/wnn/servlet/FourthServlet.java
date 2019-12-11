package com.wnn.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FourthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * HttpServletRequest：
         * 功能：
         * 1. 可以接收请求参数
         * 2. 可以获取上下文路径
         * 3. 可以作为一个域对象，有web资源之间共享数据
         * 4. 可以转发到其它资源
         *
         * 转发：当servlet收到请求后会在服务器中将请求转到其它servlet进行处理
         * 转发特点：
         *      浏览器发送了1次请求
         *      浏览器地址栏url没有变化
         *
         * */


        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);

        String contextPath = request.getContextPath();
        System.out.println("上下文路径："+contextPath);

        request.setAttribute("gender","male");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/firstServlet");
        requestDispatcher.forward(request,response);


//       response.setContentType("text/html;charset=utf-8");
//        response.getWriter().println("post请求被处理");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        System.out.println("username:"+username);

        response.getWriter().println("哈哈");

        /*
        * HttpServletResponse:
        * 功能：
        * 1.可以向页面返回数据信息
        * 2.可以重定向到另外一个资源
        *
        * 重定向：当servlet收到请求后，会返回浏览器一个状态码302和一个url地址（location)，浏览器看到状态码后，会重新访问location地址
        * HTTP/1.1 302 Found
          Location: /firstServlet
        *
        * 浏览器发送了2次请求
        * 浏览器地址栏也发生了变化
        *
        * */



//        response.sendRedirect(request.getContextPath()+"/firstServlet");


//        response.setContentType("text/html;charset=utf-8");
//        获取输出流
//        PrintWriter writer = response.getWriter();
//        writer.println("Get请求被处理");



    }
}
