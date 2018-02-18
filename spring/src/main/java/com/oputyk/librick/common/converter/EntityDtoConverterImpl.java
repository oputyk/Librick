package com.oputyk.librick.common.converter;

import com.oputyk.librick.common.converter.reflection.GenericTypeResolverImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class EntityDtoConverterImpl<E> implements EntityDtoConverter<E> {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GenericTypeResolverImpl typeResolver;
    private final Class<E> eClass;

    public EntityDtoConverterImpl() {
        eClass = typeResolver.resolveGenericTypeOf(this.getClass());
    }

    @Override
    public <D> D toDto(E entity) throws NoSuchMethodException {
        Method toDtoMethod = getClass().getMethod("toDto", Object.class);
        Class<D> dClass = typeResolver.resolveGenericTypeOf(toDtoMethod);

        return modelMapper.map(entity, dClass);
    }

    @Override
    public <D> E toEntity(D dto, E oldEntity) throws NoSuchFieldException {
        return null;
    }
}