package com.jack.demo.service.impl;

import com.jack.demo.dao.BookRepository;
import com.jack.demo.dto.book.req.BookCreateReq;
import com.jack.demo.dto.book.req.BookQueryReq;
import com.jack.demo.entity.Book;
import com.jack.demo.enums.YesOrNoEnum;
import com.jack.demo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepository bookRepository;

    @Override
    public void create(BookCreateReq bookCreateReq) {
        Book book = Book.builder()
                .bookname(bookCreateReq.getBookname())
                .price(bookCreateReq.getPrice())
                .store(bookCreateReq.getStore())
                .version(0)
                .isdeleted(YesOrNoEnum.NO.getCodeValue())
                .updatetime(new Date())
                .createtime(new Date())
                .build();

        bookRepository.save(book);
    }

    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }

    @Override
    public List<Book> query(BookQueryReq bookQueryReq) {
        return bookRepository.findAll();
    }
}
