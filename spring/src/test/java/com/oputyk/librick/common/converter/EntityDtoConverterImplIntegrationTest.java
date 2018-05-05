package com.oputyk.librick.common.converter;

import com.oputyk.librick.Application;
import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.FullBookDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 23/02/2018.
 */

@ActiveProfiles("test")
@ContextConfiguration(classes = {Application.class })
@RunWith(SpringRunner.class)
public class EntityDtoConverterImplIntegrationTest {
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    private BookEntity bookEntity;
    private FullBookDto fullBookDto;
    private BookEntity oldBookEntity;

    private LocalDate now = LocalDate.now();
    private Long bookId = 1L;
    private String bookName = "Book name";
    private String bookDescription = "Book description.";
    private Long oldBookId = 2L;

    @Before
    public void setUp() {
        initFullBookDto();
        initBookEntity();
        initOldBookEntity();
    }

    @Test
    public void testBookFullDtoToEntity() {
        BookEntity convertedEntity;
        convertedEntity = (BookEntity) entityDtoConverter
                .toEntity(oldBookEntity, fullBookDto);

        assertThat(convertedEntity).isEqualToComparingFieldByFieldRecursively(bookEntity);
    }

    private void initFullBookDto() {
        fullBookDto = FullBookDto.builder()
                .id(bookId)
                .name(bookName)
                .releaseDate(now)
                .description(bookDescription)
                .build();
    }

    private void initBookEntity() {
        bookEntity = BookEntity.builder()
                .id(bookId)
                .name(bookName)
                .releaseDate(now)
                .description(bookDescription)
                .build();
    }

    private void initOldBookEntity() {
        oldBookEntity = BookEntity.builder()
                .id(oldBookId)
                .build();
    }

}
