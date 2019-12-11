package com.wnn.bs.servlet;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Cart;
import com.wnn.bs.service.BookService;
import com.wnn.bs.service.impl.BookServiceImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends BaseServlet {

    BookService bs = new BookServiceImpl();

    //添加图书
    protected void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图书id
        String bookid = request.getParameter("bookid");
        Book book = bs.getBookById(bookid);

        //获取session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        // 第一次添加图书时没有购物车，需要先创建购物车，同时需要放入session中
        if(cart==null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }

        cart.addBookToCart(book);
        session.setAttribute("title",book.getTitle());

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
    //删除图书
    protected void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String bookid = request.getParameter("bookid");

        //获取session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.deleteCartItemBybookid(bookid);

        //返回购物车页面
        response.sendRedirect("pages/cart/cart.jsp");
    }
    //修改图书数量
    protected void updateBookCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取图书id
        String bookid = request.getParameter("bookid");
        String count = request.getParameter("count");

        //获取购物车
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        //修改数量
        cart.updateCountByBookid(bookid,Integer.parseInt(count));
        //返回购物车页面
        response.sendRedirect("pages/cart/cart.jsp");
    }
    //清空购物车
    protected void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        cart.clearCart();

        //返回购物车页面
        response.sendRedirect("pages/cart/cart.jsp");
    }
}
