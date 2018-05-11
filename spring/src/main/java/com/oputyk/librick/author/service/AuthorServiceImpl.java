package com.oputyk.librick.author.service;

import com.oputyk.librick.author.converter.AuthorConverter;
import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.domain.AuthorRepository;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.author.dto.FullAuthorDto;
import com.oputyk.librick.book.domain.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorConverter authorConverter;

    @Override
    public List<AuthorDto> findAllAuthorDtos() {
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        return authorEntities.stream()
                .map(authorConverter::toAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FullAuthorDto> findAllFullAuthorsDto() {
        List<AuthorEntity> authorEntities = authorRepository.findAll();

        return authorEntities.stream()
                .map(authorConverter::toFullAuthorDto)
                .collect(Collectors.toList());
    }

    @Override
    public FullAuthorDto updateOrSaveAuthor(FullAuthorDto fullAuthorDto) {
        authorConverter.toAuthorEntity(fullAuthorDto);

        return fullAuthorDto;
    }

    @Override
    public boolean deleteAuthor(Long id) {
        if(authorRepository.exists(id)) {
            AuthorEntity authorEntity = authorRepository.getOne(id);

            authorEntity.updateBookEntities(new ArrayList<>());

            authorRepository.delete(id);

            return true;
        }

        return false;
    }
}
