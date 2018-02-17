package com.oputyk.librick.bookinstance.dto;

import com.oputyk.librick.book.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kamil on 04/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookInstanceDto {
    private Long isbn;
}
