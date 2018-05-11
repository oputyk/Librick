package com.oputyk.librick.author.service;

import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.author.dto.FullAuthorDto;

import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */
public interface AuthorService {
    List<AuthorDto> findAllAuthorDtos();

    List<FullAuthorDto> findAllFullAuthorsDto();

    FullAuthorDto updateOrSaveAuthor(FullAuthorDto fullAuthorDto);

    boolean deleteAuthor(Long id);
}
