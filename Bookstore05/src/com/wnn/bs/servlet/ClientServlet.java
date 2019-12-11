package com.wnn.bs.servlet;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;
import com.wnn.bs.service.BookService;
import com.wnn.bs.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientServlet extends BaseServlet {

    BookService bs = new BookServiceImpl();

    protected void getpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageNo = request.getParameter("pageNo");
        // String pageSize = request.getParameter("pageSize");
        String pageSize = "4";
        //调用分页功能
        Page<Book> page = bs.getPage(pageSize, pageNo);

        //将图书列表设置到域中
        request.setAttribute("page",page);
//        String referer = request.getHeader("referer");
//        System.out.println("referer=========:"+referer);
        page.setUrl("ClientServlet?method=getpage");

        //转发到book_manager.jsp
        request.getRequestDispatcher("pages/client.jsp").forward(request,response);
    }

    protected void getpagebyprice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageSize = "4";
        String pageNo = request.getParameter("pageNo");
        String minprice = request.getParameter("minprice");
        String maxprice = request.getParameter("maxprice");

        //获取page
        Page<Book> page = bs.getPageByPrice(pageNo, pageSize, minprice, maxprice);
        page.setUrl("ClientServlet?method=getpagebyprice&minprice="+minprice+"&maxprice="+maxprice);

        //设置到域中
        request.setAttribute("page",page);
        request.setAttribute("min",minprice);
        request.setAttribute("max",maxprice);

        //转发到book_manager.jsp
        request.getRequestDispatcher("pages/client.jsp").forward(request,response);

    }
}
