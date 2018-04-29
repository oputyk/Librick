package com.oputyk.librick.book.domain;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
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
@Setter
@Getter
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "bookEntities")
    private List<AuthorEntity> authors = new ArrayList<>();
    private String description;
    private LocalDate releaseDate;

    @OneToMany(mappedBy = "bookEntity")
    private List<BookInstanceEntity> bookInstances = new ArrayList<>();

    // BookEntity (many) - AuthorEntity (many) //
    public void updateAuthorEntities(List<AuthorEntity> newAuthorEntities) {
        if (newAuthorEntities != null) {
            List<AuthorEntity> toRemove = authors.stream()
                    .filter(authorEntity -> !newAuthorEntities.contains(authorEntity))
                    .collect(Collectors.toList());

            List<AuthorEntity> toAdd = newAuthorEntities.stream()
                    .filter(authorEntity -> !authors.contains(authorEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeAuthorEntity);
            toAdd.forEach(this::addAuthorEntity);
        } else {
            authors.clear();
        }
    }

    public void addAuthorEntity(AuthorEntity authorEntity) {
        authors.add(authorEntity);
        if (!authorEntity.getBookEntities().contains(this)) {
            authorEntity.addBookEntity(this);
        }
    }

    public void removeAuthorEntity(AuthorEntity authorEntity) {
        authors.remove(authorEntity);
        if (authorEntity.getBookEntities().contains(this)) {
            authorEntity.removeBookEntity(this);
        }
    }


    // BookEntity (one) - BookInstanceEntity (many) //
    public void updateBookInstanceEntities(List<BookInstanceEntity> newBookInstanceEntities) {
        if (newBookInstanceEntities != null) {
            List<BookInstanceEntity> toRemove = bookInstances.stream()
                    .filter(bookInstanceEntity -> !newBookInstanceEntities.contains(bookInstanceEntity))
                    .collect(Collectors.toList());

            List<BookInstanceEntity> toAdd = newBookInstanceEntities.stream()
                    .filter(bookInstanceEntity -> !bookInstances.contains(bookInstanceEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeBookInstanceEntity);
            toAdd.forEach(this::addBookInstanceEntity);
        } else {
            bookInstances.clear();
        }
    }

    public void addBookInstanceEntity(BookInstanceEntity bookInstanceEntity) {
        bookInstances.add(bookInstanceEntity);
        if (bookInstanceEntity.getBookEntity() != this) {
            bookInstanceEntity.updateBookEntity(this);
        }
    }

    public void removeBookInstanceEntity(BookInstanceEntity bookInstanceEntity) {
        bookInstances.remove(bookInstanceEntity);
        if (bookInstanceEntity.getBookEntity() == this) {
            bookInstanceEntity.updateBookEntity(null);
        }
    }
}