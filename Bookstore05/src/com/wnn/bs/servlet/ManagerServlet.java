package com.wnn.bs.servlet;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;
import com.wnn.bs.service.BookService;
import com.wnn.bs.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "ManagerServlet")
public class ManagerServlet extends BaseServlet {
    BookService bs = new BookServiceImpl();

    protected void saveorupdate(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");

        if(null==id){
            Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
            boolean flag = bs.saveBook(book);
            //TODO
            if(flag){
                response.sendRedirect("pages/manager/book_manager.jsp");
            }else{
                //图书名或作者相同时视为重复
                request.setAttribute("msg","此图书已经存在");
                request.setAttribute("book",book);
                request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
            }

        }else{
            Book book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
            boolean flag = bs.updateBook(book);
            //重定向到图书列表
            response.sendRedirect("/ManagerServlet?method=getallbook");
        }
    }

    //处理图书保存请求
    protected void savebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");

        Book book = new Book(null, title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        boolean flag = bs.saveBook(book);
        flag = false;
        //TODO
        if(flag){
           response.sendRedirect("pages/manager/book_manager.jsp");
        }else{
            //图书名或作者相同时视为重复
           request.setAttribute("msg","此图书已经存在");
           request.setAttribute("book",book);
           request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
        }


    }
    //处理图书修改请求
    protected void updatebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String id = request.getParameter("bookId");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String price = request.getParameter("price");
        String sales = request.getParameter("sales");
        String stock = request.getParameter("stock");

        Book book = new Book(Integer.parseInt(id), title, author, Double.parseDouble(price), Integer.parseInt(sales), Integer.parseInt(stock));
        boolean flag = bs.updateBook(book);
        //重定向到图书列表
        response.sendRedirect("/ManagerServlet?method=getallbook");

    }
    //处理图书删除请求
    protected void deletebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数bookId
        String bookId = request.getParameter("bookId");
        //删除图书
        boolean b = bs.deleteBook(bookId);
        //重定向到ManagerServlet?method=getallbook
        response.sendRedirect("ManagerServlet?method=getallbook");

    }
    //处理查寻一本图书请求
    protected void getbookbyid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图书id
        String bookId = request.getParameter("bookId");
        //查找图书
        Book book = bs.getBookById(bookId);
        //将图书设置到域中
        request.setAttribute("book",book);
        //转发页面到book_edit.jsp
        request.getRequestDispatcher("pages/manager/book_edit.jsp").forward(request,response);

    }
    //处理查寻所有图书请求
    protected void getallbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        查找所有图书列表
        List<Book> books = bs.getAllBook();
        //将图书列表设置到域中
        request.setAttribute("books",books);
        //转发到book_manager.jsp
        request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request,response);
    }

    //分页图书请求
    protected void getpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String pageNo = request.getParameter("pageNo");
       // String pageSize = request.getParameter("pageSize");
        String pageSize = "4";
        //调用分页功能
        Page<Book> page = bs.getPage(pageSize, pageNo);
        page.setUrl("ManagerServlet?method=getpage");
        //将图书列表设置到域中
        request.setAttribute("page",page);

        //转发到book_manager.jsp
        request.getRequestDispatcher("pages/manager/book_manager.jsp").forward(request,response);
    }

}
