package com.oputyk.librick.author.service;

import com.oputyk.librick.author.dto.AuthorDto;

import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */
public interface AuthorService {
    List<AuthorDto> findAllAuthorDtos();
}
