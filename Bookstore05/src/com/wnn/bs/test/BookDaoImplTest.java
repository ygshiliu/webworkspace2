package com.wnn.bs.test;

import com.wnn.bs.bean.Book;
import com.wnn.bs.dao.BookDao;
import com.wnn.bs.dao.impl.BookDaoImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookDaoImplTest {

    BookDao bd = new BookDaoImpl();

    @Test
    public void saveBook() {
        Book book = new Book(null,"时间简史","霍金",54.00,50,50);
        int i = bd.saveBook(book);
        System.out.println("savebook:"+i);
    }

    @Test
    public void updateBook() {
        Book book = new Book(43,"时间简史1","霍金1",54.00,50,50);
        int i = bd.updateBook(book);
        System.out.println("updateBook:"+i);
    }

    @Test
    public void deleteBook() {
        int i = bd.deleteBook("43");
        System.out.println("deleteBook:"+i);
    }

    @Test
    public void getBookById() {
        Book book = bd.getBookById("43");
        System.out.println("getBookById:"+book);
    }

    @Test
    public void getAllBook() {
        List<Book> books = bd.getAllBook();
        for (Book book :books) {
            System.out.println(book);
        }


    }
}