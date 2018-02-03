package com.oputyk.librick.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kamil on 03/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}
