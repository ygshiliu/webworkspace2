package com.wnn.servlet;

import javax.servlet.*;
import java.io.IOException;

public class SecondeServlet implements Servlet {

    public SecondeServlet() {

        System.out.println("======servlet构造器被调用");
    }

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {
        System.out.println("======init()被调用");
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("======getServletConfig()被调用");
        return null;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("======service()被调用");

        ServletContext servletContext = servletRequest.getServletContext();
        String title = (String) servletContext.getAttribute("title");
        System.out.println("共享数据："+title);

    }

    @Override
    public String getServletInfo() {
        System.out.println("======getServletInfo()被调用");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("======destroy()被调用");
    }
}
