package com.oputyk.librick.bookinstance.domain;

import com.oputyk.librick.book.domain.BookEntity;
import com.oputyk.librick.borrow.domain.BorrowEntity;
import com.oputyk.librick.borrow.dto.BorrowDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kamil on 03/02/2018.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book_instance")
public class BookInstanceEntity {
    @Id
    @GeneratedValue
    private Long isbn;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private BookEntity bookEntity;
    private Date buyDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrow_id")
    private BorrowEntity borrowEntity;

    // BookInstanceEntity (many) - BookEntity (one) - created by live template //
    public void updateBookEntity(BookEntity newBookEntity) {
        bookEntity.removeBookInstanceEntity(this);
        bookEntity = newBookEntity;
        if (newBookEntity != null && !newBookEntity.getBookInstanceEntities().contains(this)) {
            newBookEntity.addBookInstanceEntity(this);
        }
    }
}
