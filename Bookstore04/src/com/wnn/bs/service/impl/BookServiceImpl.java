package com.wnn.bs.service.impl;

import com.wnn.bs.bean.Book;
import com.wnn.bs.bean.Page;
import com.wnn.bs.dao.BookDao;
import com.wnn.bs.dao.impl.BookDaoImpl;
import com.wnn.bs.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bd = new BookDaoImpl();
    @Override
    public boolean saveBook(final Book book) {
        return bd.saveBook(book)>0;
    }

    @Override
    public boolean updateBook(final Book book) {
        return bd.updateBook(book)>0;
    }

    @Override
    public boolean deleteBook(final String bookId) {
        return bd.deleteBook(bookId)>0;
    }

    @Override
    public Book getBookById(final String bookId) {
        return bd.getBookById(bookId);
    }

    @Override
    public List<Book> getAllBook() {
        return bd.getAllBook();
    }

    @Override
    public Page<Book> getPage(final String pageSizeStr, final String pageNoStr) {
        //需要转换参数
        int pageSize = 4;
        int pageNo = 1;

        try {
            pageSize = Integer.parseInt(pageSizeStr);
        }catch (Exception e){}
        try {
            pageNo = Integer.parseInt(pageNoStr);
        }catch (Exception e){}

        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        bd.getPage(page);
        return page;
    }

    @Override
    public Page<Book> getPageByPrice(final String pageNoStr, final String pageSizeStr, final String minstr, final String maxstr) {
        //需要转换参数
        int pageSize = 4;
        int pageNo = 1;

        try {
            pageSize = Integer.parseInt(pageSizeStr);
        }catch (Exception e){}
        try {
            pageNo = Integer.parseInt(pageNoStr);
        }catch (Exception e){}

        double min = 0;
        double max = Double.MAX_VALUE;

        try {
            min=Double.parseDouble(minstr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            max=Double.parseDouble(maxstr);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        bd.getPageByPrice(page,min,max);
        return page;
    }

}
