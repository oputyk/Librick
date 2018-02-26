package com.oputyk.librick.author.domain;

import com.oputyk.librick.book.domain.BookEntity;
import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 03/02/2018.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;

    @ManyToMany(cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.REFRESH,
                    CascadeType.MERGE })
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<BookEntity> bookEntities = new ArrayList<>();

    // AuthorEntity (many) - BookEntity (many) //
    public void updateBookEntities(List<BookEntity> newBookEntities) {
        if (newBookEntities != null) {
            List<BookEntity> toRemove = bookEntities.stream()
                    .filter(bookEntity -> !newBookEntities.contains(bookEntity))
                    .collect(Collectors.toList());

            List<BookEntity> toAdd = newBookEntities.stream()
                    .filter(bookEntity -> !bookEntities.contains(bookEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeBookEntity);
            toAdd.forEach(this::addBookEntity);
        } else {
            bookEntities.clear();
        }
    }

    public void addBookEntity(BookEntity bookEntity) {
        bookEntities.add(bookEntity);
        if (!bookEntity.getAuthorEntities().contains(this)) {
            bookEntity.addAuthorEntity(this);
        }
    }

    public void removeBookEntity(BookEntity bookEntity) {
        bookEntities.remove(bookEntity);
        if (bookEntity.getAuthorEntities().contains(this)) {
            bookEntity.removeAuthorEntity(this);
        }
    }

}
