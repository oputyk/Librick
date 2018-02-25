package com.oputyk.librick.book.converter;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.common.converter.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 03/02/2018.
 */

@Service
public class BookConverterImpl implements BookConverter {
    @Autowired
    private EntityDtoConverter converter;

    @Override
    public BookDto toBookDto(BookEntity bookEntity) {
        return (BookDto) converter.toDto(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity toBookEntity(BookDto bookDto) {
        return null;
    }

    @Override
    public FullBookDto toFullBookDto(BookEntity bookEntity) {
        return (FullBookDto) converter.toDto(bookEntity, FullBookDto.class);    }

    @Override
    public BookEntity toBookEntity(FullBookDto fullBookDto) {
        return null;
    }
}
