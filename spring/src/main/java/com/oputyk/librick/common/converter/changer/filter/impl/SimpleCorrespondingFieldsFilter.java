package com.oputyk.librick.common.converter.changer.filter.impl;

import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by kamil on 19/02/2018.
 */

@Service
public class SimpleCorrespondingFieldsFilter implements CorrespondingFieldsFilter {
    @Override
    public boolean filter(Field entityField, Field dtoField) {
        boolean sameNames = entityField.getName().equals(dtoField.getName());
        boolean sameClasses = entityField.getClass().equals(dtoField.getClass());

        if(sameClasses && entityField.getGenericType() instanceof ParameterizedType
                && dtoField.getGenericType() instanceof ParameterizedType) {
            ParameterizedType entityParameterizedType = (ParameterizedType)
                    entityField.getGenericType();

            ParameterizedType dtoParameterizedType = (ParameterizedType)
                    dtoField.getGenericType();

            if (areParameterTypesDifferent(entityParameterizedType, dtoParameterizedType)) {
                return false;
            }
        }

        return sameNames && sameClasses;
    }

    private boolean areParameterTypesDifferent(ParameterizedType entityParameterizedType, ParameterizedType dtoParameterizedType) {
        Type[] entityTypeArguments = entityParameterizedType.getActualTypeArguments();
        Type[] dtoTypeArguments = dtoParameterizedType.getActualTypeArguments();

        if(entityTypeArguments.length == dtoTypeArguments.length) {
            for(int i = 0; i < entityTypeArguments.length; i++) {
                if(!entityTypeArguments[i].equals(dtoTypeArguments[i])) {
                    return true;
                }
            }
        }

        return false;
    }
}
