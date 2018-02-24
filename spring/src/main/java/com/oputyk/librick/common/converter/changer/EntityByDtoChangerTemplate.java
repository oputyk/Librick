package com.oputyk.librick.common.converter.changer;

import com.oputyk.librick.common.converter.changer.assigner.FieldsAssigner;
import com.oputyk.librick.common.converter.changer.filter.CorrespondingFieldsFilter;
import lombok.Builder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kamil on 22/02/2018.
 */

@Builder
public class EntityByDtoChangerTemplate implements EntityByDtoChanger {
    private List<CorrespondingFieldsFilter> fieldsFilters;
    private FieldsAssigner fieldsAssigner;

    @Override
    public Object changeEntityByDto(Object entity, Object dto) {
        Field[] entityFields = entity.getClass().getDeclaredFields();
        Field[] dtoFields = dto.getClass().getDeclaredFields();

        Map<Field, Field> correspondingDtoEntityFields;
        correspondingDtoEntityFields = groupAllFieldsByFilters(dtoFields, entityFields, fieldsFilters);

        assignFromToFields(dto, entity, correspondingDtoEntityFields);
        
        return entity;
    }

    private Map<Field, Field> groupAllFieldsByFilters(Field[] fields1, Field[] fields2, List<CorrespondingFieldsFilter> filters) {
        Map<Field, Field> correspondingFields = new HashMap<>();

        for(Field field1 : fields1)
            for(Field field2 : fields2)
                if(filterByAllFilters(field1, field2))
                    correspondingFields.put(field1, field2);

        return correspondingFields;
    }

    private void assignFromToFields(Object from, Object to, Map<Field, Field> fromToFields) {
        fromToFields.forEach(
                ((fromField, toField) ->
                        fieldsAssigner.assignFromTo(from, to, fromField, toField)));
    }

    private boolean filterByAllFilters(Field field1, Field field2) {
        return fieldsFilters.stream()
                .allMatch(fieldsFilter -> fieldsFilter.filter(field1, field2));
    }
}
