package com.oputyk.librick.common.converter;

import com.oputyk.librick.Application;
import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import configuration.TestConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 23/02/2018.
 */

@ContextConfiguration(classes = { Application.class, TestConfig.class}, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringRunner.class)
public class EntityDtoConverterImplIntegrationTest {
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @Qualifier("bookEntity1")
    @Autowired
    private BookEntity newBookEntity;

    @Qualifier("bookDto1")
    @Autowired
    private BookDto bookDto;

    @Qualifier("bookEntity2")
    @Autowired
    private BookEntity oldBookEntity;

    @Test
    public void whenChangeEntityByDto_thenReturnWellConvertedEntity() {
        BookEntity convertedEntity = (BookEntity) entityDtoConverter.toEntity(oldBookEntity, bookDto);

        assertThat(convertedEntity).isEqualToComparingFieldByField(newBookEntity);
    }

}
