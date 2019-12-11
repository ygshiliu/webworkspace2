package com.wnn.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ThridServlet implements Servlet {
    
    private ServletConfig servletConfig;
    
    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(final ServletRequest servletRequest, final ServletResponse servletResponse) throws ServletException, IOException {
        
        //获取servletContext
        ServletContext servletContext = servletConfig.getServletContext();

        /*
        servletContext介绍：
        * 1.可以获取项目名
        * 2.可以获取初始化参数
        * 3.可以获取资源的物理路径
        * 4.可以作为域对象，在不同web资源间共享数据
        *
        *
        * 物理路径：就是本地系统，以c: d:等盘符开始的路径，如c:\a.txt
        * 虚拟路径：是指在web服务器上的资源对应的路径
        *
        * web资源比如图片，html，css ，servlet，且它们都有唯一的虚拟路径         *
        * http://127.0.0.1:8080/day06/ThridServlet
        * D:\onlineEducation\webworkspace2\out\artifacts\day06_servlet_war_exploded\ThridServlet
        *
        * */
/*
        String contextPath = servletContext.getContextPath();
        System.out.println("项目名："+contextPath);

        String totalcount = servletContext.getInitParameter("totalcount");
        System.out.println("项目初始化参数："+totalcount);

        String thridServlet = servletContext.getRealPath("ThridServlet");
        System.out.println("物理路径："+thridServlet);

        servletContext.setAttribute("title","JAVA WEB 开发");*/




    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
