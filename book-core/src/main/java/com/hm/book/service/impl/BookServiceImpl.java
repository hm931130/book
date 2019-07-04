package com.hm.book.service.impl;

import com.hm.book.bean.Book;
import com.hm.book.mapper.BookMapper;
import com.hm.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bookmgr
 * @Date: 2019/7/3 14:57
 * @Author: Mr.Han
 * @Description:
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public void addBooks(List<Book> books) {
        bookMapper.addBooks(books);
    }


    public List<Book> findAllBooks(String cid) {
        return bookMapper.findAllBooks(cid);
    }
}
