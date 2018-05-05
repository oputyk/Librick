package com.oputyk.librick.author.converter;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.domain.AuthorRepository;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.common.converter.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 03/02/2018.
 */

@Service
public class AuthorConverterImpl implements AuthorConverter {
    private final AuthorRepository authorRepository;
    private final EntityDtoConverter converter;

    @Autowired
    public AuthorConverterImpl(AuthorRepository authorRepository, EntityDtoConverter converter) {
        this.authorRepository = authorRepository;
        this.converter = converter;
    }

    @Override
    public AuthorDto toAuthorDto(AuthorEntity authorEntity) {
        return (AuthorDto) converter.toDto(authorEntity, AuthorDto.class);
    }

    @Override
    public AuthorEntity toAuthorEntity(AuthorDto authorDto) {
            AuthorEntity oldAuthorEntity;
            oldAuthorEntity = findEntityAndCreateIfDoesntExist(authorDto.getId());

            return (AuthorEntity) converter.toEntity(oldAuthorEntity, authorDto);
    }

    private AuthorEntity findEntityAndCreateIfDoesntExist(Long id) {
            AuthorEntity authorEntity = authorRepository.findOne(id);

            if(authorEntity == null) {
                authorEntity = new AuthorEntity();
                authorEntity.setId(id);

                authorRepository.save(authorEntity);
            }

            return authorEntity;
    }
}
