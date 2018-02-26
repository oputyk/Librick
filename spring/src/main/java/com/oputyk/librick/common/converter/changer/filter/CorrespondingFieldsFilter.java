package com.oputyk.librick.common.converter.changer.filter;

import java.lang.reflect.Field;

/**
 * Created by kamil on 19/02/2018.
 */
public interface CorrespondingFieldsFilter {
    boolean filter(Field entityField, Field dtoField);
}
