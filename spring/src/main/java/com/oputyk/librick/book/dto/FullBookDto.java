package com.oputyk.librick.book.dto;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.author.dto.AuthorDto;
import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import com.oputyk.librick.bookinstance.dto.BookInstanceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kamil on 24/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FullBookDto {
    private Long id;
    private String name;
    private List<AuthorDto> authors = new ArrayList<>();
    private String description;
    private LocalDate releaseDate;
    private List<BookInstanceDto> bookInstances = new ArrayList<>();
}
