package com.oputyk.librick.book.service;

import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;

import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */

public interface BookService {
    List<BookDto> findAllBookDtos();

    List<FullBookDto> findAllFullBookDtos();
}
