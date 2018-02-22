package com.oputyk.librick.common.converter;

import com.oputyk.librick.common.converter.filter.CorrespondingFieldsFilter;
import com.oputyk.librick.common.converter.reflection.operator.field.FieldOperator;
import com.oputyk.librick.common.converter.reflection.operator.method.MethodOperator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class EntityDtoConverterImpl implements EntityDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private List<CorrespondingFieldsFilter> correspondingFieldsFilters;

    @Override
    public Object toDto(Object entity, Class<?> dtoClass) throws NoSuchMethodException {
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public Object toEntity(Object dto, Object oldEntity) throws NoSuchFieldException {
        Field[] oldEntityFields = oldEntity.getClass().getDeclaredFields();
        Field[] dtoFields = dto.getClass().getDeclaredFields();

        Map<Field, Field> correspondingFields = findCorrespondingFields(oldEntityFields, dtoFields);

        Object newEntity = changeEntityByDto(oldEntity, dto, correspondingFields);

        return newEntity;
    }

    private Map<Field,Field> findCorrespondingFields(Field[] fields1, Field[] fields2) {
        Map<Field, Field> correspondingFields = new HashMap<>();

        for(Field field1 : fields1)
            for(Field field2 : fields2)
                if(areCorrespondingFields(field1, field2))
                    correspondingFields.put(field1, field2);

        return correspondingFields;
    }

    private Object changeEntityByDto(Object oldEntity, Object dto, Map<Field, Field> correspondingFields) {


        return oldEntity;
    }

    private boolean areCorrespondingFields(Field field1, Field field2) {
        return correspondingFieldsFilters.stream()
                .anyMatch(filter -> filter.filter(field1, field2));
    }
}