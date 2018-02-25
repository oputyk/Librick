package com.oputyk.librick.common.converter.entitydtoconverter.reflection.operator.method;

import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by kamil on 20/02/2018.
 */

@Service
public class MethodOperatorImpl implements MethodOperator {
    @Override
    public Method findMethodInClassByName(Class<?> clazz, String name) {
        return findMethodInClassByNameAndArgs(clazz, name, new Class<?>[0]);
    }

    @Override
    public Object invokeMethod(Object object, Method method) {
        return invokeMethod(object, method, new Object[0]);
    }

    @Override
    public Object invokeMethod(Object object, Method method, Object[] args) {
        try {
            return method.invoke(object, args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't invoke method " + method.getName()
                    + " in " + object.getClass().getSimpleName() + " class.");
        }
    }

    @Override
    public Method findMethodInClassByNameAndArgs(Class<?> clazz, String name, Class<?>[] parametersTypes) {
        try {
            Method foundMethod = clazz.getDeclaredMethod(name, parametersTypes);

            if(foundMethod == null) {
                throw new RuntimeException("Couldn't find " + name + " method of "
                        + clazz.getSimpleName() + " class.");
            }

            return foundMethod;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't find " + name + " method of "
                    + clazz.getSimpleName() + " class.");
        }
    }
}
