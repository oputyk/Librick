package com.oputyk.librick.borrow.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by kamil on 05/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowDto {
    private Long id;
    private LocalDate date;
    private LocalDate deadline;
}
