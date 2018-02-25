package com.oputyk.librick.common.converter.entitydtoconverter.changer.assigner.impl;

import com.oputyk.librick.common.converter.entitydtoconverter.changer.assigner.AbstractFieldsAssigner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

/**
 * Created by kamil on 22/02/2018.
 */

@Order(1)
@Service
public class SimpleFieldsAssigner extends AbstractFieldsAssigner {
    @Override
    public Object assignFromTo(Object from, Object to, Field fromField, Field toField) {
        return assignFromToByGetterAndSetter(from, to, fromField, toField);
    }
}
