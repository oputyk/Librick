package com.oputyk.librick.common.converter.entitydtoconverter.reflection.operator.object;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by kamil on 22/02/2018.
 */

public interface ObjectOperator {
    Object assignBySettersAndGetters(Object from, Object to, Map<Field, Field> fromToFields);

    Object assignBySetterAndGetter(Object from, Object to, Field fromField, Field toField);
}
