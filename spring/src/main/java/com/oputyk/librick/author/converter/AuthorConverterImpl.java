package com.oputyk.librick.author.converter;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.domain.AuthorRepository;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.common.converter.entitydtoconverter.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 03/02/2018.
 */

@Service
public class AuthorConverterImpl implements AuthorConverter {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private EntityDtoConverter converter;

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
