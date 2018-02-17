package com.oputyk.librick.reader.domain;

import com.oputyk.librick.borrow.domain.BorrowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kamil on 17/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "reader")
public class ReaderEntity {
    @Id
    @GeneratedValue
    private Long idCard;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "readerEntity")
    private List<BorrowEntity> borrowEntities;
}
