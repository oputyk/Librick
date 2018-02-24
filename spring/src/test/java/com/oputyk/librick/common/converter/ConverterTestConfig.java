package com.oputyk.librick.common.converter;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.book.dto.BookDto;
import com.oputyk.librick.common.converter.changer.EntityByDtoChanger;
import com.oputyk.librick.common.converter.changer.EntityByDtoChangerTemplate;
import com.oputyk.librick.common.converter.changer.assigner.FieldsAssigner;
import com.oputyk.librick.common.converter.changer.assigner.impl.SimpleFieldsAssigner;
import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.changer.filter.impl.SimpleCorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.reflection.operator.annotation.AnnotationOperator;
import com.oputyk.librick.common.converter.reflection.operator.annotation.AnnotationOperatorImpl;
import com.oputyk.librick.common.converter.reflection.operator.field.FieldOperator;
import com.oputyk.librick.common.converter.reflection.operator.field.FieldOperatorImpl;
import com.oputyk.librick.common.converter.reflection.operator.method.MethodOperator;
import com.oputyk.librick.common.converter.reflection.operator.method.MethodOperatorImpl;
import com.oputyk.librick.common.converter.reflection.operator.object.ObjectOperator;
import com.oputyk.librick.common.converter.reflection.operator.object.ObjectOperatorImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by kamil on 23/02/2018.
 */

@Configuration
public class ConverterTestConfig {
    private String newBookName = "Book name";
    private Date newBookRealeaseDate = new Date();
    private long newBookId = 1L;;
    private String newBookDescription = "Some description about the book.";
    private Long oldBookId = newBookId + 3L;

    @Qualifier("newBookEntity")
    @Bean
    public BookEntity newBookEntity() {
         return BookEntity.builder()
                .id(newBookId)
                .name(newBookName)
                .releaseDate(newBookRealeaseDate)
                .description(newBookDescription)
                .build();
    }

    @Qualifier("bookDto")
    @Bean
    public BookDto bookDto() {
        return BookDto.builder()
                .id(newBookId)
                .name(newBookName)
                .releaseDate(newBookRealeaseDate)
                .description(newBookDescription)
                .build();
    }

    @Qualifier("oldBookEntity")
    @Bean
    public BookEntity oldBookEntity() {
         return BookEntity.builder()
                .id(oldBookId)
                 .build();
    }

    @Bean
    public CorrespondingFieldsFilter correspondingFieldsFilter() {
        return new SimpleCorrespondingFieldsFilter();
    }

    @Bean
    public FieldsAssigner fieldsAssigner() {
        return new SimpleFieldsAssigner();
    }

    @Bean
    public EntityByDtoChanger entityByDtoChanger() {
        return EntityByDtoChangerTemplate.builder()
                .fieldsFilters(Arrays.asList(correspondingFieldsFilter()))
                .fieldsAssigner(fieldsAssigner())
                .build();
    }

    @Bean
    public FieldOperator fieldOperator() {
        return new FieldOperatorImpl();
    }

    @Bean
    public MethodOperator methodOperator() {
        return new MethodOperatorImpl();
    }

    @Bean
    public AnnotationOperator annotationOperator() {
        return new AnnotationOperatorImpl();
    }

    @Bean
    public ObjectOperator objectOperator() {
        return new ObjectOperatorImpl();
    }

    @Bean
    public EntityDtoConverter entityDtoConverterImpl() {
        return new EntityDtoConverterImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public MethodOperatorImpl methodOperatorImpl() {
        return new MethodOperatorImpl();
    }

}
