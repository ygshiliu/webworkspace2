package com.wnn.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MySessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建session对象,同时创建一个JSESSIONID的cookie对象并发送给浏览器，如下：
        //Set-Cookie: JSESSIONID=F3F1D8BE20EEB6FC1B3A8782E3F7E2DA; Path=/; HttpOnly
        HttpSession session = request.getSession();

        //打印一下session对象的属性
        String id = session.getId();
        System.out.println("session id:"+id);
        /*
        通过在web.xml中设置session的配置项来指定session的有效时间。默认是30分钟
            <session-config>
                <session-timeout>30</session-timeout>
            </session-config>

         */
        /*
            手动设置session的有效时间，单位秒
            当值为正值时，session的空闲时间为指定时间
            当值为0时，session的空闲时间为一次会话。也是默认值
            当值为负值时，永远不超时，同一次会话。
         */
        session.setMaxInactiveInterval(-30);
        int maxInactiveInterval = session.getMaxInactiveInterval();
        System.out.println("空闲时间："+maxInactiveInterval+"秒");
        boolean flag = session.isNew();
        System.out.println("session是否为新的："+flag);

        //手动设置session失效
        session.invalidate();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
