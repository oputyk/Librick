package com.oputyk.librick.common.converter;

/**
 * Created by kamil on 17/02/2018.
 */
public interface EntityDtoConverter {
    Object toDto(Object entity, Class<?> dtoClass);

    Object toEntity(Object oldEntity, Object dto);
}
