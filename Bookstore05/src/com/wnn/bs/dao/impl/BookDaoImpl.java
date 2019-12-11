package com.wnn.bs.dao.impl;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;
import com.wnn.bs.dao.BaseDao;
import com.wnn.bs.dao.BookDao;

import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    @Override
    public int saveBook(final Book book) {
        String sql = "insert into bs_book(title,author,price,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int updateBook(final Book book) {
        String sql="update bs_book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql,book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(),book.getId());
    }

    @Override
    public int deleteBook(final String bookId) {
        String sql = "delete from bs_book where id=?";
        return update(sql,bookId);
    }

    @Override
    public Book getBookById(final String bookId) {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where id=?";
        return getBean(sql,bookId);
    }

    @Override
    public List<Book> getAllBook() {
        String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book ";
        return getBeanList(sql);
    }

    @Override
    public Page<Book> getPage(final Page<Book> page) {

        //获取图书总记录数
        String sql  = "select count(id) from bs_book";
        long count = getCount(sql);
        page.setTotalRecord((int) count);

        // 获取图书
        sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book limit ?,?";
        List<Book> books = getBeanList(sql, page.getIndex(), page.getPageSize());
        page.setList(books);

        return page;
    }

    @Override
    public Page<Book> getPageByPrice(final Page<Book> page, final double min, final double max) {
        //获取图书总记录数
        String sql  = "select count(id) from bs_book where price>=? and price<=?";
        long count = getCount(sql,min,max);
        page.setTotalRecord((int) count);

        // 获取图书
        sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book  where price>=? and price<=? limit ?,?";
        List<Book> books = getBeanList(sql,min,max, page.getIndex(), page.getPageSize());
        page.setList(books);

        return page;
    }
}
