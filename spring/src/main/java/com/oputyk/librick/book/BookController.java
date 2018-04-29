package com.oputyk.librick.book;

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
    @Autowired
    private BookService bookService;

    @GetMapping("all")
    public List<FullBookDto> all() {
        return bookService.findAllFullBookDtos();
    }

    @PostMapping("book")
    public FullBookDto updateOrSaveBook(@RequestBody FullBookDto fullBookDto) {
        return bookService.updateOrSaveBook(fullBookDto);
    }
}
