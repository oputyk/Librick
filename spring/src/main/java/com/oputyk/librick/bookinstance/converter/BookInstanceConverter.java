package com.oputyk.librick.bookinstance.converter;

import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import com.oputyk.librick.bookinstance.dto.BookInstanceDto;

/**
 * Created by kamil on 17/02/2018.
 */
public interface BookInstanceConverter {
    BookInstanceEntity toBookInstanceEntity(BookInstanceDto bookInstanceDto);
}
