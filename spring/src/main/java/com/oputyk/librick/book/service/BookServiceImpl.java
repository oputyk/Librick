package com.oputyk.librick.book.service;

import com.oputyk.librick.book.converter.BookConverter;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.domain.BookRepository;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 17/02/2018.
 */
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDto> findAllBookDtos() {
        List<BookEntity> bookEntities = bookRepository.findAll();

        return bookEntities.stream()
                .map(bookEntity -> bookConverter.toBookDto(bookEntity))
                .collect(Collectors.toList());
    }

    @Override
    public List<FullBookDto> findAllFullBookDtos() {
        List<BookEntity> bookEntities = bookRepository.findAll();

        return bookEntities.stream()
                .map(bookEntity -> bookConverter.toFullBookDto(bookEntity))
                .collect(Collectors.toList());
    }
}
