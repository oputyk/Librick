package com.oputyk.librick.author.converter;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.author.dto.FullAuthorDto;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public interface AuthorConverter {
    AuthorDto toAuthorDto(AuthorEntity authorEntity);

    AuthorEntity toAuthorEntity(AuthorDto authorDto);

    FullAuthorDto toFullAuthorDto(AuthorEntity authorEntity);

    AuthorEntity toAuthorEntity(FullAuthorDto fullAuthorDto);
}
