package com.oputyk.librick.author.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oputyk.librick.book.domain.BookEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 03/02/2018.
 */

@Builder
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

    @JsonFormat(pattern = "dd::MM::yyyy")
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"))
    private List<BookEntity> books = new ArrayList<>();

    @Override
    public boolean equals(Object authorEntity) {
        if(authorEntity == this)
            return true;
        else if(authorEntity instanceof  AuthorEntity && id != null)
            return id.equals(((AuthorEntity) authorEntity).getId());
        else
            return false;
    }

    // AuthorEntity (many) - BookEntity (many) //
    public void updateBookEntities(List<BookEntity> newBookEntities) {
        if (newBookEntities != null) {
            List<BookEntity> toRemove = books.stream()
                    .filter(bookEntity -> !newBookEntities.contains(bookEntity))
                    .collect(Collectors.toList());

            List<BookEntity> toAdd = newBookEntities.stream()
                    .filter(bookEntity -> !books.contains(bookEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeBookEntity);
            toAdd.forEach(this::addBookEntity);
        } else {
            books.clear();
        }
    }

    public void addBookEntity(BookEntity bookEntity) {
        books.add(bookEntity);
        if (!bookEntity.getAuthors().contains(this)) {
            bookEntity.addAuthorEntity(this);
        }
    }

    public void removeBookEntity(BookEntity bookEntity) {
        books.remove(bookEntity);
        if (bookEntity.getAuthors().contains(this)) {
            bookEntity.removeAuthorEntity(this);
        }
    }

}
