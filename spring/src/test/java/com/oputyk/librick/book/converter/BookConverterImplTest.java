package com.oputyk.librick.book.converter;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import com.oputyk.librick.common.converter.EntityDtoConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 24/02/2018.
 */

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class BookConverterImplTest {
    @Autowired
    private BookConverter bookConverter;

    @MockBean
    private EntityDtoConverter entityDtoConverter;

    private BookEntity bookEntity;
    private FullBookDto fullBookDto;
    private BookEntity oldBookEntity;
    private BookEntity halfConvertedBookEntity;

    @TestConfiguration
    static public class BookConverterImplTestConfig {
        @Bean
        public BookConverter bookConverterImpl() {
            return new BookConverterImpl();
        }
    }

    @Before
    public void setUp() throws Exception {
        Date now = new Date();

        List<AuthorEntity> authorEntities = Arrays.asList(
                new AuthorEntity(1L, "firstName", "lastName", 1, Arrays.asList(bookEntity)),
                new AuthorEntity(2L, "firstName2", "lastName2", 2, Arrays.asList(bookEntity)));

        List<AuthorDto> authorDtos = Arrays.asList(
                new AuthorDto(1L, "firstName", "lastName", 1),
                new AuthorDto(2L, "firstName2", "lastName2", 2)
        );

        List<AuthorEntity> oldAuthorEntities = Arrays.asList(
                new AuthorEntity(3L, "firstName3", "lastName3", 3, Arrays.asList(oldBookEntity)));

        bookEntity = new BookEntity(1L, "name", authorEntities, "description", now, null);
        fullBookDto = new FullBookDto(1L, "name", authorDtos, "description", now, null);
        oldBookEntity = new BookEntity(2L, "name2", oldAuthorEntities, "description2", null, null);
        halfConvertedBookEntity = new BookEntity(1L, "name", oldAuthorEntities, "description", null, null);
    }

    @Test
    public void toFullBookDto() throws Exception {
        Mockito.when(entityDtoConverter.toDto(bookEntity, FullBookDto.class))
                .thenReturn(fullBookDto);

        assertThat(bookConverter.toFullBookDto(bookEntity))
                .isEqualToComparingFieldByFieldRecursively(fullBookDto);
    }

    @Test
    public void fullBookTotoBookEntity() throws Exception {
        Mockito.when(entityDtoConverter.toEntity(oldBookEntity, fullBookDto))
                .thenReturn(halfConvertedBookEntity);

        assertThat(bookConverter.toBookEntity(fullBookDto))
                .isEqualToComparingFieldByField(bookEntity);
    }

}