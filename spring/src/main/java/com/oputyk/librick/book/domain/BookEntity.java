package com.oputyk.librick.book.domain;

import com.oputyk.librick.author.domain.AuthorEntity;
import com.oputyk.librick.bookinstance.domain.BookInstanceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by kamil on 03/02/2018.
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "bookEntities")
    private List<AuthorEntity> authorEntities;
    private String description;
    private Date releaseDate;

    @OneToMany(mappedBy = "bookEntity")
    private List<BookInstanceEntity> bookInstanceEntities;

    // BookEntity (many) - AuthorEntity (many) //
    public void updateAuthorEntities(List<AuthorEntity> newAuthorEntities) {
        if (newAuthorEntities != null) {
            List<AuthorEntity> toRemove = authorEntities.stream()
                    .filter(authorEntity -> !newAuthorEntities.contains(authorEntity))
                    .collect(Collectors.toList());

            List<AuthorEntity> toAdd = newAuthorEntities.stream()
                    .filter(authorEntity -> !authorEntities.contains(authorEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeAuthorEntity);
            toAdd.forEach(this::addAuthorEntity);
        } else {
            authorEntities.clear();
        }
    }

    public void addAuthorEntity(AuthorEntity authorEntity) {
        authorEntities.add(authorEntity);
        if (!authorEntities.contains(this)) {
            authorEntity.addBookEntity(this);
        }
    }

    public void removeAuthorEntity(AuthorEntity authorEntity) {
        authorEntities.remove(authorEntity);
        if (authorEntities.contains(this)) {
            authorEntity.removeBookEntity(this);
        }
    }


    // BookEntity (one) - BookInstanceEntity (many) //
    public void updateBookInstanceEntities(List<BookInstanceEntity> newBookInstanceEntities) {
        if (newBookInstanceEntities != null) {
            List<BookInstanceEntity> toRemove = bookInstanceEntities.stream()
                    .filter(bookInstanceEntity -> !newBookInstanceEntities.contains(bookInstanceEntity))
                    .collect(Collectors.toList());

            List<BookInstanceEntity> toAdd = newBookInstanceEntities.stream()
                    .filter(bookInstanceEntity -> !bookInstanceEntities.contains(bookInstanceEntity))
                    .collect(Collectors.toList());

            toRemove.forEach(this::removeBookInstanceEntity);
            toAdd.forEach(this::addBookInstanceEntity);
        } else {
            bookInstanceEntities.clear();
        }
    }

    public void addBookInstanceEntity(BookInstanceEntity bookInstanceEntity) {
        bookInstanceEntities.add(bookInstanceEntity);
        if (!bookInstanceEntities.contains(this)) {
            bookInstanceEntity.updateBookEntity(this);
        }
    }

    public void removeBookInstanceEntity(BookInstanceEntity bookInstanceEntity) {
        bookInstanceEntities.remove(bookInstanceEntity);
        if (bookInstanceEntities.contains(this)) {
            bookInstanceEntity.updateBookEntity(null);
        }
    }
}