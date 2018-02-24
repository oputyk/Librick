package com.oputyk.librick.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by kamil on 03/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private Long id;
    private String name;
    private String description;
    private Date releaseDate;
}
