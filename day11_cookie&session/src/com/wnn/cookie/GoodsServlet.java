package com.wnn.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie
        Cookie trousers = new Cookie("Goods1", "trousers");
        Cookie laptop = new Cookie("Goods2", "laptop");

        //cookie默认有效时间是一次会话
        //单位是秒
        //
        /*
        * 当值为正数时，则有效时间为指定的值
        * Set-Cookie: Goods1=trousers; Expires=Mon, 18-Nov-2019 07:54:21 GMT 格林威治时间，与我们差8个小时
        * 当值为0时，则表示立即失效
        * Set-Cookie: Goods1=trousers; Expires=Thu, 01-Jan-1970 00:00:10 GMT
        * 当值负数时，表示一次会话，也是默认值
        * Set-Cookie: Goods1=trousers
        * */
        trousers.setMaxAge(-30);
        laptop.setMaxAge(-30);

        //cookie可以设置有效路径
        //Set-Cookie: Goods1=trousers; Path=""
        //cookie默认的路径就是项目根目录
        trousers.setPath(request.getContextPath());
        //Set-Cookie: Goods2=laptop; Path=/aaa/bbb
        //只有访问指定路径下的资源时才会携带此cookie
        laptop.setPath(request.getContextPath()+"/aaa/bbb");

        //传递给浏览器
        //会在响应头中添加如下信息：Set-Cookie: Goods=trousers
        //以后浏览器访问服务器时都会携带着此cookie
        response.addCookie(trousers);
        response.addCookie(laptop);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
