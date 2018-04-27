package com.oputyk.librick.book;

import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("all")
    public List<BookDto> all() {
        return bookService.findAllBookDtos();
    }
}
