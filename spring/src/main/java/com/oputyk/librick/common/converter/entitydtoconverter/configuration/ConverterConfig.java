package com.oputyk.librick.common.converter.entitydtoconverter.configuration;

import com.oputyk.librick.common.converter.entitydtoconverter.changer.EntityByDtoChanger;
import com.oputyk.librick.common.converter.entitydtoconverter.changer.EntityByDtoChangerTemplate;
import com.oputyk.librick.common.converter.entitydtoconverter.changer.assigner.impl.SimpleFieldsAssigner;
import com.oputyk.librick.common.converter.entitydtoconverter.changer.filter.impl.SimpleCorrespondingFieldsFilter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/**
 * Created by kamil on 22/02/2018.
 */

@Configuration
public class ConverterConfig {
    @Autowired
    private SimpleCorrespondingFieldsFilter simpleCorrespondingFieldsFilter;

    @Autowired
    private SimpleFieldsAssigner simpleFieldsAssigner;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    @Order(1)
    EntityByDtoChanger simpleChanger() {
        return EntityByDtoChangerTemplate.builder()
                .fieldsFilters(Arrays.asList(simpleCorrespondingFieldsFilter))
                .fieldsAssigner(simpleFieldsAssigner)
                .build();
    }
}
