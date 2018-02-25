package com.oputyk.librick.common.converter.entitydtoconverter.reflection.operator.method;

import java.lang.reflect.Method;

/**
 * Created by kamil on 20/02/2018.
 */

public interface MethodOperator {
    Method findMethodInClassByName(Class<?> clazz, String name);

    Object invokeMethod(Object object, Method method);

    Object invokeMethod(Object object, Method method, Object... args);

    Method findMethodInClassByNameAndArgs(Class<?> clazz, String name, Class<?>[] parametersTypes);
}
