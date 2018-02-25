package com.oputyk.librick.common.converter.entitydtoconverter.changer.filter.impl;

import com.oputyk.librick.common.converter.entitydtoconverter.changer.filter.CorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.entitydtoconverter.reflection.operator.annotation.AnnotationOperator;
import com.oputyk.librick.common.converter.entitydtoconverter.reflection.annotation.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by kamil on 19/02/2018.
 */

@Service
public class EntityDtoFieldsFilter implements CorrespondingFieldsFilter {
    @Autowired
    private AnnotationOperator annotationOperator;

    @Override
    public boolean filter(Field entityField, Field dtoField) {
        Class<?> entityFieldType = entityField.getType();
        Class<?> dtoFieldType = dtoField.getType();

        return isDtoClassRelatedWithEntityClass(entityFieldType, dtoFieldType);
    }

    private boolean isDtoClassRelatedWithEntityClass(Class<?> entityClass, Class<?> dtoClass) {
        if(isDto(dtoClass) && isEntity(entityClass)) {
            return getEntityClassRelatedWithDto(dtoClass).equals(entityClass);
        } else {
            return false;
        }
    }

    private boolean isEntity(Class<?> entityClass) {
        return annotationOperator.hasClassAnnotationClass(entityClass, Entity.class);
    }

    private boolean isDto(Class<?> dtoClass) {
        return annotationOperator.hasClassAnnotationClass(dtoClass, Dto.class);
    }

    private Class<?> getEntityClassRelatedWithDto(Class<?> dtoClass) {
        Annotation dtoAnnotation = annotationOperator.findAnnotationInClassByAnnotationClass(dtoClass, Dto.class);

        return annotationOperator.getAnnotationParameterValueByName(dtoAnnotation, "entityClass");
    }
}
