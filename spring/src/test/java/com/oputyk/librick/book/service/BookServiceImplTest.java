package com.oputyk.librick.book.service;

import com.oputyk.librick.book.converter.BookConverter;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.domain.BookRepository;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.book.dto.FullBookDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 25/02/2018.
 */

@RunWith(SpringRunner.class)
public class BookServiceImplTest {
    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository bookRepository;

    @MockBean
    private BookConverter bookConverter;

    private BookEntity bookEntity;
    private BookDto bookDto;
    private FullBookDto fullBookDto;

    @TestConfiguration
    static public class BookServiceImplTestConfig {
        @Bean
        public BookService bookServiceImpl() {
            return new BookServiceImpl();
        }
    }

    @Before
    public void setUp() throws Exception {
        initBookEntity();
        initBookDto();
        initFullBookDto();
    }

    @Before
    public void setUpMocks() {
        Mockito.when(bookRepository.findAll())
                .thenReturn(new ArrayList<>(Arrays.asList(bookEntity)));

        Mockito.when(bookConverter.toBookDto(bookEntity))
                .thenReturn(bookDto);

        Mockito.when(bookConverter.toFullBookDto(bookEntity))
                .thenReturn(fullBookDto);
    }

    @Test
    public void findAllBookDtos() throws Exception {
        assertThat(bookService.findAllBookDtos().contains(bookDto))
                .isTrue();

        assertThat(bookService.findAllBookDtos().size()).isEqualTo(1);
    }

    @Test
    public void findAllFullBookDtos() throws Exception {
        assertThat(bookService.findAllFullBookDtos().contains(fullBookDto))
                .isTrue();

        assertThat(bookService.findAllFullBookDtos().size()).isEqualTo(1);
    }

    private void initFullBookDto() {
        fullBookDto = new FullBookDto(1L, "entity", null, "description", null, null);
    }

    private void initBookDto() {
        bookDto = new BookDto(1L, "entity", "description", null);
    }

    private void initBookEntity() {
        bookEntity = new BookEntity(1L, "entity", null, "description", null, null);
    }

}