package com.oputyk.librick.common.converter.reflection.operator.method;

import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by kamil on 20/02/2018.
 */

@Service
public class MethodOperatorImpl implements MethodOperator {
    @Override
    public Method findMethodInClassByName(Class<?> clazz, String name) {
        return findMethodInClassByNameAndArgs(clazz, name, null);
    }

    @Override
    public Object invokeMethod(Object object, Method method) {
        return invokeMethod(object, null);
    }

    @Override
    public Object invokeMethod(Object object, Method method, Object... args) {
        try {
            return method.invoke(object, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            throw new RuntimeException("Couldn't invoke method " + method.getName()
                    + " in " + object.getClass().getSimpleName() + " class with no arguments.");
        }
    }

    @Override
    public Method findMethodInClassByNameAndArgs(Class<?> clazz, String name, Class<?>[] parametersTypes) {
        try {
            Method foundMethod = findAndReturnMethodOfClassByNameIfPossible(clazz, name);

            if (foundMethod != null) {
                return foundMethod;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            throw new RuntimeException("Couldn't find " + name + " method of "
                    + clazz.getSimpleName() + " class.");
        }
    }

    private Method findAndReturnMethodOfClassByNameIfPossible(Class<?> clazz, String name) throws NoSuchMethodException {
        Optional<Method> foundMethod = Optional.ofNullable(clazz.getDeclaredMethod(name, null));

        if(foundMethod.isPresent()) {
            return foundMethod.get();
        }
        return null;
    }
}
