package com.oputyk.librick.common.converter.reflection;

import java.lang.reflect.Method;

/**
 * Created by kamil on 18/02/2018.
 */
public interface GenericTypeResolver {
    <G, T> Class<T> resolveGenericTypeOf(Class<G> genericClass);
    <G, T> Class<T> resolveGenericTypeOf(Method genericMethod);
}
