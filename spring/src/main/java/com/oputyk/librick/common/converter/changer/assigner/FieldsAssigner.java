package com.oputyk.librick.common.converter.changer.assigner;

import java.lang.reflect.Field;

/**
 * Created by kamil on 22/02/2018.
 */

public interface FieldsAssigner {
    Object assignFromTo(Object from, Object to, Field fromField, Field toField);
}
