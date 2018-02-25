package com.oputyk.librick.common.converter.entitydtoconverter.changer.assigner;

import com.oputyk.librick.common.converter.entitydtoconverter.reflection.operator.field.FieldOperator;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * Created by kamil on 22/02/2018.
 */

public abstract class AbstractFieldsAssigner implements FieldsAssigner {
    @Autowired
    protected FieldOperator fieldOperator;

    protected Object assignFromToByGetterAndSetter(Object from, Object to, Field fromField, Field toField) {
        Object newValue = fieldOperator.getByGetter(from, fromField);

        fieldOperator.setBySetter(to, toField, newValue);

        return to;
    }
}
