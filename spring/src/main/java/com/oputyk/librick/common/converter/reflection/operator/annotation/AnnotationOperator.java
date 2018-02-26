package com.oputyk.librick.common.converter.reflection.operator.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by kamil on 20/02/2018.
 */
public interface AnnotationOperator {
    Annotation findAnnotationInClassByAnnotationClass(Class<?> clazz, Class<?> annotationClass);

    Class<?> getAnnotationParameterValueByName(Annotation annotation, String parameterName);

    Method getAnnotationParameterByName(Annotation annotation, String parameterName);

    boolean hasClassAnnotationClass(Class<?> clazz, Class<?> annotationClass);
}
