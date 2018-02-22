package com.oputyk.librick.common.converter.changer;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by kamil on 22/02/2018.
 */

public interface EntityDtoChanger {
    Object changeEntityByDto(Object entity, Object dto);
}
