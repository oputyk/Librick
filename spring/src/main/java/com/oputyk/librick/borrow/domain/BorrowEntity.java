package com.oputyk.librick.borrow.domain;

import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import com.oputyk.librick.reader.domain.ReaderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Reader;
import java.util.Date;

/**
 * Created by kamil on 05/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "borrow")
public class BorrowEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_instance_id")
    private BookInstanceEntity bookInstanceEntity;
    private Date date;
    private Date deadline;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private ReaderEntity readerEntity;

}
