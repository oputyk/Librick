package com.oputyk.librick.author.dto;

import com.oputyk.librick.book.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullAuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private List<BookDto> books;
}
