package com.wnn.bs.dao;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;

import java.util.List;

/**
 * 定义与图书操作相关的方法
 */
public interface BookDao {

    //保存图书
    public int saveBook(Book book);
    //修改图书
    public int updateBook(Book book);
    //删除图书
    public int deleteBook(String bookId);
    //查找一本图书
    public Book getBookById(String bookId);
    //查找图书列表
    public List<Book> getAllBook();
    //分页查找图书列表
    public Page<Book> getPage(Page<Book> page);
    //操作带价格的分页
    public Page<Book> getPageByPrice(Page<Book> page,double min,double max);

}
