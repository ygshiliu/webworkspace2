package com.wnn.bs.service;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;

import java.util.List;

/**
 * 图书操作相关的业务方法
 */
public interface BookService {
    //保存图书
    public boolean saveBook(Book book);
    //修改图书
    public boolean updateBook(Book book);
    //删除图书
    public boolean deleteBook(String bookId);
    //查找一本图书
    public Book getBookById(String bookId);
    //查找图书列表
    public List<Book> getAllBook();

//    分页查找图书
    public Page<Book> getPage(String pageSizeStr, String pageNoStr);
    // 带价格分页查找图书
    public Page<Book> getPageByPrice(String pageNo,String pageSize,String minstr,String maxstr);
}
