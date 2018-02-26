package com.oputyk.librick.bookinstance.converter;

import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import com.oputyk.librick.bookinstance.domain.BookInstanceRepository;
import com.oputyk.librick.bookinstance.dto.BookInstanceDto;
import com.oputyk.librick.common.converter.EntityDtoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 03/02/2018.
 */

@Service
public class BookInstanceConverterImpl implements BookInstanceConverter {
    private final BookInstanceRepository bookInstanceRepository;

    private final EntityDtoConverter converter;

    @Autowired
    public BookInstanceConverterImpl(BookInstanceRepository bookInstanceRepository, EntityDtoConverter converter) {
        this.bookInstanceRepository = bookInstanceRepository;
        this.converter = converter;
    }

    @Override
    public BookInstanceEntity toBookInstanceEntity(BookInstanceDto bookInstanceDto) {
            BookInstanceEntity oldBookInstanceEntity;
            oldBookInstanceEntity = findEntityAndCreateIfDoesntExist(bookInstanceDto.getIsbn());

            return (BookInstanceEntity) converter.toEntity(oldBookInstanceEntity, bookInstanceDto);
    }


    private BookInstanceEntity findEntityAndCreateIfDoesntExist(Long isbn) {
            BookInstanceEntity bookInstanceEntity = bookInstanceRepository.findOne(isbn);

            if(bookInstanceEntity == null) {
                bookInstanceEntity = new BookInstanceEntity();
                bookInstanceEntity.setIsbn(isbn);

                bookInstanceRepository.save(bookInstanceEntity);
            }

            return bookInstanceEntity;
        }
}
