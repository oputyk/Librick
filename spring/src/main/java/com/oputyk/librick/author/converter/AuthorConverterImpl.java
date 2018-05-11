package com.oputyk.librick.author.converter;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.domain.AuthorRepository;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.author.dto.FullAuthorDto;
import com.oputyk.librick.book.converter.BookConverter;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.FullBookDto;
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
public class AuthorConverterImpl implements AuthorConverter {
    private final AuthorRepository authorRepository;
    private final EntityDtoConverter converter;

    @Autowired
    private BookConverter bookConverter;

    @Autowired
    public AuthorConverterImpl(AuthorRepository authorRepository,
                               EntityDtoConverter converter) {
        this.authorRepository = authorRepository;
        this.converter = converter;
    }

    @Override
    public AuthorDto toAuthorDto(AuthorEntity authorEntity) {
        return (AuthorDto) converter.toDto(authorEntity, AuthorDto.class);
    }

    @Override
    public FullAuthorDto toFullAuthorDto(AuthorEntity authorEntity) {
        return (FullAuthorDto) converter.toDto(authorEntity, FullAuthorDto.class);

    }

    @Override
    public AuthorEntity toAuthorEntity(FullAuthorDto fullAuthorDto) {
        AuthorEntity oldAuthorEntity;
        oldAuthorEntity = findEntityAndCreateIfDoesntExist(fullAuthorDto.getId());
        fullAuthorDto.setId(oldAuthorEntity.getId());

        AuthorEntity newAuthorEntity;
        newAuthorEntity = (AuthorEntity) converter.toEntity(oldAuthorEntity, fullAuthorDto);

        if(fullAuthorDto.getBooks() != null) {
            List<BookEntity> newBookEntities;
            newBookEntities = fullAuthorDto.getBooks().stream()
                    .map(bookConverter::toBookEntity)
                    .collect(Collectors.toList());

            newAuthorEntity.updateBookEntities(newBookEntities);
        }

        return newAuthorEntity;
    }

    @Override
    public AuthorEntity toAuthorEntity(AuthorDto authorDto) {
        AuthorEntity oldAuthorEntity;
        oldAuthorEntity = findEntityAndCreateIfDoesntExist(authorDto.getId());
        oldAuthorEntity.setId(authorDto.getId());

        return (AuthorEntity) converter.toEntity(oldAuthorEntity, authorDto);
    }

    private AuthorEntity findEntityAndCreateIfDoesntExist(Long id) {
        if(id == null) {
            return authorRepository.save(new AuthorEntity());
        }

        AuthorEntity authorEntity = authorRepository.findOne(id);

        if(authorEntity == null) {
            authorEntity = new AuthorEntity();
            authorEntity.setId(id);

            authorRepository.save(authorEntity);
        }

        return authorEntity;
    }
}
