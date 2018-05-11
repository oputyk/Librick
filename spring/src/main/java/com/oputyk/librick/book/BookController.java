package com.oputyk.librick.book;

import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("all")
    public List<BookDto> all() {
        return bookService.findAllBookDtos();
    }

    @GetMapping("all-full")
    public List<FullBookDto> allFull() {
        return bookService.findAllFullBookDtos();
    }
}
