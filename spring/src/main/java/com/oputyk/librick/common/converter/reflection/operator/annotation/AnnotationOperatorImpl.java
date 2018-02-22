package com.oputyk.librick.common.converter.reflection.operator.annotation;

import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by kamil on 20/02/2018.
 */

@Service
public class AnnotationOperatorImpl implements AnnotationOperator {
    @Override
    public Annotation findAnnotationInClassByAnnotationClass(Class<?> clazz, Class<?> annotationClass) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();

        Optional<Annotation> foundAnnotation = Arrays.stream(annotations)
                .filter(annotation -> annotation.equals(annotationClass))
                .findAny();

        if(!foundAnnotation.isPresent()) {
            return foundAnnotation.get();
        } else {
            throw new RuntimeException(
                    "Not found @" + annotationClass.getSimpleName()
                            + " annotation in " + clazz.getSimpleName() + " class.");
        }
    }

    @Override
    public Class<?> getAnnotationParameterValueByName(Annotation annotation, String parameterName) {
        Method annotationPatameter = getAnnotationParameterByName(annotation, parameterName);

        try {
            return (Class<?>) annotationPatameter.invoke(annotation, (Object[]) null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            throw new RuntimeException("Can't get value of @" + annotation.annotationType().getSimpleName()
                    + " annotation's parameter - " + parameterName + ".");
        }
    }

    @Override
    public Method getAnnotationParameterByName(Annotation annotation, String parameterName) {
        Class<?> annotationType = annotation.annotationType();

        Optional<Method> annotationParameter = Arrays.stream(annotationType.getDeclaredMethods())
                .filter(method -> method.getName().equals(parameterName))
                .findAny();

        if(annotationParameter.isPresent()) {
            return annotationParameter.get();
        } else {
            throw new RuntimeException(
                    "Not found " + parameterName + " annotation parameter in @"
                            + annotationType.getSimpleName() + " annotation.");
        }
    }

    @Override
    public boolean hasClassAnnotationClass(Class<?> clazz, Class<?> annotationClass) {
        return Arrays.stream(clazz.getDeclaredAnnotations())
                .anyMatch(annot -> annot.annotationType().equals(annotationClass));
    }
}
