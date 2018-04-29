package com.oputyk.librick.bookinstance.domain;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.borrow.domain.BorrowEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by kamil on 03/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book_instance")
public class BookInstanceEntity {
    @Id
    @GeneratedValue
    private Long isbn;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    private LocalDate buyDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrow_id")
    private BorrowEntity borrowEntity;

    // BookInstanceEntity (many) - BookEntity (one) - created by live template //
    public void updateBookEntity(BookEntity newBookEntity) {
        bookEntity.removeBookInstanceEntity(this);
        bookEntity = newBookEntity;
        if (newBookEntity != null && !newBookEntity.getBookInstances().contains(this)) {
            newBookEntity.addBookInstanceEntity(this);
        }
    }
}
