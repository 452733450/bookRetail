package com.jack.demo.web.contorller;

import com.jack.demo.annotation.ResponseWrapable;

import com.jack.demo.dto.book.req.BookCreateReq;
import com.jack.demo.dto.book.req.BookQueryReq;
import com.jack.demo.entity.Book;
import com.jack.demo.service.BookService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("book")
@Validated
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping("/create")
    @ResponseWrapable
    public void create(@RequestBody @Valid BookCreateReq bookCreateReq) {
        bookService.create(bookCreateReq);
    }

    @PostMapping("/query")
    @ResponseWrapable
    public List<Book> query(@RequestBody @Valid BookQueryReq bookQueryReq) {
        return bookService.query(bookQueryReq);
    }


    @PostMapping("/deleteAll")
    @ResponseWrapable
    public void deleteAll() {
        bookService.deleteAll();
    }
}
