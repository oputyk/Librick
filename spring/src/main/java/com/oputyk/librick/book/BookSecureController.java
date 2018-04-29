package com.oputyk.librick.book;

import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

/**
 * Created by kamil on 04/02/2018.
 */

@RestController
@RequestMapping("book/secure")
public class BookSecureController {
    private final BookService bookService;

    @Autowired
    public BookSecureController(BookService bookService) {
        this.bookService = bookService;
    }

    @PreAuthorize("hasRole('ROLE_LIBRARIAN')")
    @PostMapping("book/")
    public FullBookDto updateOrSaveBook(@RequestBody FullBookDto fullBookDto) {
        return bookService.updateBook(fullBookDto);
    }
}
