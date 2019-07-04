package com.hm.book.service;

import com.hm.book.bean.Book;

import java.util.List;

/**
 * @program: bookmgr
 * @Date: 2019/7/3 14:57
 * @Author: Mr.Han
 * @Description:
 */
public interface BookService {

    void addBooks(List<Book> books);


    List<Book> findAllBooks(String cid);
}
