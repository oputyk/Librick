package com.oputyk.librick.reader.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by kamil on 17/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderDto {
    private Long idCard;
    private String firstName;
    private String lastName;
}
