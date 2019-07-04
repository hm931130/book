package com.hm.book.mapper;

import com.hm.book.bean.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    void addBooks(@Param("books") List<Book> books);


    List<Book> findAllBooks(@Param("cid") String cid);
}