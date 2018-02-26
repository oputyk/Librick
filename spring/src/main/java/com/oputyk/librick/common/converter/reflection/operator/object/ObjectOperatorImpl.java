package com.oputyk.librick.common.converter.reflection.operator.object;

import com.oputyk.librick.common.converter.reflection.operator.field.FieldOperator;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by kamil on 22/02/2018.
 */
public class ObjectOperatorImpl implements ObjectOperator {
    @Autowired
    private FieldOperator fieldOperator;

    @Override
    public Object assignBySettersAndGetters(Object from, Object to, Map<Field, Field> fromToFields) {
        fromToFields.forEach((fromField, toField) -> assignBySetterAndGetter(from, to, fromField, toField));

        return to;
    }

    @Override
    public Object assignBySetterAndGetter(Object from, Object to, Field fromField, Field toField) {
        Object newValue = fieldOperator.getByGetter(from, fromField);

        fieldOperator.setBySetter(to, toField, newValue);

        return to;
    }
}
