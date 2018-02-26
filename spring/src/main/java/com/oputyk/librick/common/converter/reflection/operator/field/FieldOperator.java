package com.oputyk.librick.common.converter.reflection.operator.field;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by kamil on 20/02/2018.
 */
public interface FieldOperator {
    Object get(Object object, Field field);

    Object getByGetter(Object object, Field field);

    void setBySetter(Object object, Field field, Object newValue);

    Method findGetter(Class<?> clazz, Field field);

    Method findSetter(Class<?> clazz, Field field);
}
