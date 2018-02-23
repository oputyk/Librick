package com.oputyk.librick.common.converter.changer.filter.impl;

import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * Created by kamil on 19/02/2018.
 */

@Service
public class SimpleCorrespondingFieldsFilter implements CorrespondingFieldsFilter {
    @Override
    public boolean filter(Field entityField, Field dtoField) {
        boolean sameNames = entityField.getName().equals(dtoField.getName());
        boolean sameClasses = entityField.getClass().equals(dtoField.getClass());

        return sameNames && sameClasses;
    }
}
