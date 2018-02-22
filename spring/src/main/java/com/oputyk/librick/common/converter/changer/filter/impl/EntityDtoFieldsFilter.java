package com.oputyk.librick.common.converter.changer.filter.impl;

import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.reflection.operator.annotation.AnnotationOperator;
import com.oputyk.librick.common.converter.reflection.annotation.Dto;
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
    public boolean filter(Field field1, Field field2) {
        Class<?> field1Type = field1.getType();
        Class<?> field2Type = field2.getType();

        return isDtoClassRelatedWithEntityClass(field1Type, field2Type);
    }

    private boolean isDtoClassRelatedWithEntityClass(Class<?> dtoClass, Class<?> entityClass) {
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
