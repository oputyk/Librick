package com.oputyk.librick.book.converter;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;

/**
 * Created by kamil on 17/02/2018.
 */
public interface BookConverter {
    BookDto toBookDto(BookEntity bookEntity);

    BookEntity toBookEntity(BookDto bookDto);

    FullBookDto toFullBookDto(BookEntity bookEntity);

    BookEntity toBookEntity(FullBookDto fullBookDto);
}
