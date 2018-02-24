package com.oputyk.librick.common.converter;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.common.converter.changer.EntityByDtoChanger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 23/02/2018.
 */

@ContextConfiguration(classes = { ConverterTestConfig.class }, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringRunner.class)
public class EntityDtoConverterImplTest {
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @MockBean
    private EntityByDtoChanger entityByDtoChanger;

    @Qualifier("bookDto")
    @Autowired
    private BookDto bookDto;

    @Qualifier("newBookEntity")
    @Autowired
    private BookEntity bookEntity;

    @Qualifier("oldBookEntity")
    @Autowired
    private BookEntity oldBookEntity;

    @Before
    public void initMockEntityByDtoChanger() {
        Mockito.when(entityByDtoChanger.changeEntityByDto(oldBookEntity, bookDto))
                .thenReturn(bookEntity);
    }

    @Test
    public void whenToEntity_thenReturnWellConvertedDtoToEntity() {
        BookEntity convertedEntity = (BookEntity) entityDtoConverter.toEntity(oldBookEntity, bookDto);

        assertThat(convertedEntity).isEqualToComparingFieldByField(convertedEntity);
    }

    @Test
    public void whenToDto_thenReturnWellConvertedEntityToDto() {
        BookDto convertedDto = (BookDto) entityDtoConverter.toDto(bookEntity, BookDto.class);

        assertThat(convertedDto).isEqualToComparingFieldByField(bookDto);
    }

}