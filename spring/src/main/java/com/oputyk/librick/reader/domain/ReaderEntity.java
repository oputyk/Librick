package com.oputyk.librick.reader.domain;

import com.oputyk.librick.borrow.domain.BorrowEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    // ReaderEntity (one) - BorrowEntity (many) //
    public void updateBorrowEntities(List<BorrowEntity> newBorrowEntities) {
        if (newBorrowEntities != null) {
            List<BorrowEntity> toRemove = borrowEntities.stream()
                    .filter(borrowEntity -> !newBorrowEntities.contains(borrowEntity))
                    .collect(Collectors.toList());

            List<BorrowEntity> toAdd = newBorrowEntities.stream()
                    .filter(borrowEntity -> !borrowEntities.contains(borrowEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeBorrowEntity);
            toAdd.forEach(this::addBorrowEntity);
        } else {
            borrowEntities.clear();
        }
    }

    public void addBorrowEntity(BorrowEntity borrowEntity) {
        borrowEntities.add(borrowEntity);
        if (!borrowEntities.contains(this)) {
            borrowEntity.updateReaderEntity(this);
        }
    }

    public void removeBorrowEntity(BorrowEntity borrowEntity) {
        borrowEntities.remove(borrowEntity);
        if (borrowEntities.contains(this)) {
            borrowEntity.updateReaderEntity(null);
        }
    }
}
