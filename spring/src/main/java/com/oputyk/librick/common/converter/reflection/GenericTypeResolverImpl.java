package com.oputyk.librick.common.converter.reflection;

import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by kamil on 18/02/2018.
 */

@Service
public class GenericTypeResolverImpl implements GenericTypeResolver {
    public <G, T> Class<T> resolveGenericTypeOf(Class<G> genericClass) {
        return (Class<T>) ResolvableType.forClass(genericClass).resolveGeneric();
    }

    public <G, T> Class<T> resolveGenericTypeOf(Method genericMethod) {
        return (Class<T>) ResolvableType.forMethodParameter(genericMethod, 0).resolveGeneric();
    }
}
