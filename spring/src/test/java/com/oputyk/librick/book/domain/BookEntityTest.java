package com.oputyk.librick.book.domain;

import com.oputyk.librick.author.domain.AuthorEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kamil on 25/02/2018.
 */

@RunWith(SpringRunner.class)
public class BookEntityTest {

    private BookEntity bookEntity;
    private List<AuthorEntity> authorEntities;

    @Before
    public void setUp() throws Exception {
        Date now = new Date();
        authorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(1L, "firstName", "lastName", 1, new ArrayList<>(Arrays.asList(bookEntity))),
                new AuthorEntity(2L, "firstName2", "lastName2", 2, new ArrayList<>())
        ));

        List<AuthorEntity> oldAuthorEntities;
        oldAuthorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(3L, "firstName3", "lastName3", 3, new ArrayList<>(Arrays.asList(bookEntity)))
        ));

        bookEntity = new BookEntity(1L, "firstName", oldAuthorEntities, "description", now, new ArrayList<>());
    }

    @Test
    public void updateAuthorEntities() throws Exception {
        bookEntity.updateAuthorEntities(authorEntities);

        assertThat(bookEntity.getAuthorEntities().containsAll(authorEntities)).isTrue();

        assertThat(bookEntity.getAuthorEntities().size())
                .isEqualTo(authorEntities.size());
    }

    @Test
    public void addAuthorEntity() {
        bookEntity.setAuthorEntities(new ArrayList<>());

        bookEntity.addAuthorEntity(authorEntities.get(0));
        bookEntity.addAuthorEntity(authorEntities.get(1));

        assertThat(bookEntity.getAuthorEntities().containsAll(authorEntities)).isTrue();

        assertThat(bookEntity.getAuthorEntities().size())
                .isEqualTo(authorEntities.size());
    }

}