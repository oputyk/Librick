package com.oputyk.librick.common.converter.configuration;

import com.oputyk.librick.common.converter.changer.EntityDtoChanger;
import com.oputyk.librick.common.converter.changer.EntityDtoChangerTemplate;
import com.oputyk.librick.common.converter.changer.assigner.impl.OneToOneFieldsAssigner;
import com.oputyk.librick.common.converter.changer.assigner.impl.SimpleFieldsAssigner;
import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.changer.filter.impl.EntityDtoFieldsFilter;
import com.oputyk.librick.common.converter.changer.filter.impl.SimpleCorrespondingFieldsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by kamil on 22/02/2018.
 */

@Configuration
public class ConverterConfig {
    @Autowired
    private SimpleCorrespondingFieldsFilter simpleCorrespondingFieldsFilter;
    @Autowired
    private EntityDtoFieldsFilter entityDtoFieldsFilter;

    @Autowired
    private SimpleFieldsAssigner simpleFieldsAssigner;
    @Autowired
    private OneToOneFieldsAssigner oneToOneFieldsAssigner;

    @Bean
    @Order(1)
    EntityDtoChanger simpleChanger() {
        return EntityDtoChangerTemplate.builder()
                .fieldsFilters(Arrays.asList(simpleCorrespondingFieldsFilter))
                .fieldsAssigner(simpleFieldsAssigner)
                .build();
    }

    @Bean
    @Order(2)
    EntityDtoChanger oneToOneEntityChanger () {
        return EntityDtoChangerTemplate.builder()
                .fieldsFilters(Arrays.asList(entityDtoFieldsFilter))
                .fieldsAssigner(oneToOneFieldsAssigner)
                .build();
    }
}
