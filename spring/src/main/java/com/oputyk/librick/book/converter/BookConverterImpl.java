package com.oputyk.librick.book.converter;

import com.oputyk.librick.author.converter.AuthorConverter;
import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.domain.BookRepository;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.bookinstance.converter.BookInstanceConverter;
import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import com.oputyk.librick.common.converter.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 03/02/2018.
 */

@Transactional
@Service
public class BookConverterImpl implements BookConverter {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityDtoConverter converter;

    @Autowired
    private AuthorConverter authorConverter;

    @Autowired
    private BookInstanceConverter bookInstanceConverter;

    @Override
    public BookDto toBookDto(BookEntity bookEntity) {
        return (BookDto) converter.toDto(bookEntity, BookDto.class);
    }

    @Override
    public BookEntity toBookEntity(BookDto bookDto) {
        BookEntity oldBookEntity = findEntityAndCreateIfDoesntExist(bookDto.getId());
        bookDto.setId(oldBookEntity.getId());

        return (BookEntity) converter.toEntity(oldBookEntity, bookDto);
    }

    @Override
    public FullBookDto toFullBookDto(BookEntity bookEntity) {
        return (FullBookDto) converter.toDto(bookEntity, FullBookDto.class);
    }

    @Override
    public BookEntity toBookEntity(FullBookDto fullBookDto) {
        BookEntity oldBookEntity = findEntityAndCreateIfDoesntExist(fullBookDto.getId());
        fullBookDto.setId(oldBookEntity.getId());

        BookEntity newBookEntity = (BookEntity) converter.toEntity(oldBookEntity, fullBookDto);

        if(fullBookDto.getAuthors() != null) {
            List<AuthorEntity> newAuthorEntities;
            newAuthorEntities = fullBookDto.getAuthors().stream()
                    .map(authorDto -> authorConverter.toAuthorEntity(authorDto))
                    .collect(Collectors.toList());

            newBookEntity.updateAuthorEntities(newAuthorEntities);
        }


        if(fullBookDto.getBookInstances() != null) {
            List<BookInstanceEntity> newBookInstanceEntities;
            newBookInstanceEntities = fullBookDto.getBookInstances().stream()
                    .map(bookInstanceDto -> bookInstanceConverter.toBookInstanceEntity(bookInstanceDto))
                    .collect(Collectors.toList());
            newBookEntity.updateBookInstanceEntities(newBookInstanceEntities);
        }

        return newBookEntity;
    }

    private BookEntity findEntityAndCreateIfDoesntExist(Long id) {
        if(id == null) {
            return bookRepository.save(new BookEntity());
        }

        BookEntity bookEntity = bookRepository.findOne(id);

        if(bookEntity == null) {
            bookEntity = new BookEntity();
            bookEntity.setId(id);

            bookRepository.save(bookEntity);
        }

        return bookEntity;
    }
}
