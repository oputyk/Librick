package com.oputyk.librick.common.converter.filter;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * Created by kamil on 19/02/2018.
 */

@Service
public class SameFieldsNamesAndTypesFilter implements CorrespondingFieldsFilter {
    @Override
    public boolean filter(Field field1, Field field2) {
        boolean sameNames = field1.getName().equals(field2.getName());
        boolean sameClasses = field1.getClass().equals(field2.getClass());

        return sameNames && sameClasses;
    }
}
