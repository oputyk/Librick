package com.oputyk.librick.common.converter;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.common.converter.changer.EntityByDtoChanger;
import configuration.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 23/02/2018.
 */

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class EntityDtoConverterImplTest {
    @Autowired
    private EntityDtoConverter entityDtoConverter;

    @MockBean
    private EntityByDtoChanger entityByDtoChanger;

    @MockBean
    private ModelMapper modelMapper;

    private BookDto bookDto;
    private BookEntity bookEntity;
    private BookEntity oldBookEntity;

    private LocalDate now = LocalDate.now();
    private Long bookId = 1L;
    private String bookName = "Book name";
    private String bookDescription = "Book description.";
    private Long oldBookId = 2L;

    @Import(TestConfig.class)
    @TestConfiguration
    static public class EntityDtoConverterImplTestConfig {
        @Bean
        public EntityDtoConverter entityDtoConverterImpl() {
            return new EntityDtoConverterImpl();
        }
    }

    @Before
    public void setUp() {
        initBookDto();
        initBookEntity();
        initOldBookEntity();
    }

    @Test
    public void testToEntity() {
        Mockito.when(entityByDtoChanger.changeEntityByDto(oldBookEntity, bookDto))
                .thenReturn(bookEntity);

        BookEntity convertedEntity = (BookEntity) entityDtoConverter.toEntity(oldBookEntity, bookDto);

        assertThat(convertedEntity).isEqualToComparingFieldByField(convertedEntity);
    }

    private void initBookDto() {
        bookDto = BookDto.builder()
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

    @Test
    public void whenToDto_thenReturnWellConvertedEntityToDto() {
        Mockito.when(modelMapper.map(bookEntity, BookDto.class))
                .thenReturn(bookDto);

        BookDto convertedDto = (BookDto) entityDtoConverter.toDto(bookEntity, BookDto.class);


        assertThat(convertedDto).isEqualToComparingFieldByField(bookDto);
    }

}