package com.oputyk.librick.common.converter.reflection.operator.field;

import com.oputyk.librick.common.converter.reflection.operator.method.MethodOperator;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by kamil on 20/02/2018.
 */

@Service
public class FieldOperatorImpl implements FieldOperator {
    @Autowired
    private MethodOperator methodOperator;

    @Override
    public Object get(Object object, Field field) {
        try {
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Can't get value of " + field.getName() + " field in "
                    + object.getClass().getSimpleName() + " object.");
        }
    }

    @Override
    public Object getByGetter(Object object, Field field) {
        Method getter = findGetter(object.getClass(), field);

        return methodOperator.invokeMethod(object, getter);
    }

    @Override
    public void setBySetter(Object object, Field field, Object newValue) {
        Method setter = findSetter(object.getClass(), field);

        methodOperator.invokeMethod(object, setter, newValue);
    }

    @Override
    public Method findGetter(Class<?> clazz, Field field) {
        String getterName = "get" + WordUtils.capitalize(field.getName());

        return methodOperator.findMethodInClassByName(clazz, getterName);
    }

    @Override
    public Method findSetter(Class<?> clazz, Field field) {
        String setterName = "set" + WordUtils.capitalize(field.getName());
        Class[] parametersTypes = new Class<?>[]{ field.getType() };

        return methodOperator.findMethodInClassByNameAndArgs(clazz, setterName, parametersTypes);
    }
}
