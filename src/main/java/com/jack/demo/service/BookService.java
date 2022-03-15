package com.jack.demo.service;

import com.jack.demo.dto.book.req.BookCreateReq;
import com.jack.demo.dto.book.req.BookQueryReq;
import com.jack.demo.entity.Book;

import java.util.List;

/**
 * @Description:
 * @Auther: Jack You
 * @Date: 2022/03/15/14:03
 */
public interface BookService {

    void create(BookCreateReq bookCreateReq);

    void deleteAll();

    List<Book> query(BookQueryReq bookQueryReq);
}
