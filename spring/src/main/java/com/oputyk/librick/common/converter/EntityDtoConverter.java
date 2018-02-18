package com.oputyk.librick.common.converter;

/**
 * Created by kamil on 17/02/2018.
 */
public interface EntityDtoConverter<E> {
    <D> D toDto(E entity) throws NoSuchMethodException;
    <D> E toEntity(D dto, E oldEntity) throws NoSuchFieldException;
}
