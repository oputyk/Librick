package com.oputyk.librick.common.converter.entitydtoconverter;

import com.oputyk.librick.common.converter.entitydtoconverter.changer.EntityByDtoChanger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class EntityDtoConverterImpl implements EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private List<EntityByDtoChanger> entityByDtoChangers;

    @Override
    public Object toDto(Object entity, Class<?> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public Object toEntity(Object oldEntity, Object dto) {
        entityByDtoChangers.forEach(changer -> changer.changeEntityByDto(oldEntity, dto));

        return oldEntity;
    }
}