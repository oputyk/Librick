package com.oputyk.librick.book.domain;

import com.oputyk.librick.author.domain.AuthorEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
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
    private List<AuthorEntity> oldAuthorEntities;
    private LocalDate now;

    @Before
    public void setUp() throws Exception {
        initDate();
        initAuthorEntities();
        initOldAuthorEntities();
        initBookEntity();
    }

    @Test
    public void testUpdateAuthorEntities() throws Exception {
        bookEntity.updateAuthorEntities(authorEntities);

        assertThat(bookEntity.getAuthorEntities()).isEqualTo(authorEntities);
    }

    @Test
    public void testAddAuthorEntity() {
        bookEntity.setAuthorEntities(new ArrayList<>());

        bookEntity.addAuthorEntity(authorEntities.get(0));
        bookEntity.addAuthorEntity(authorEntities.get(1));

        assertThat(bookEntity.getAuthorEntities()).isEqualTo(authorEntities);
    }

    private void initDate() {
        now = LocalDate.now();
    }

    private void initAuthorEntities() {
        authorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(1L, "firstName", "lastName", LocalDate.now().minusYears(40), new ArrayList<>(Arrays.asList(bookEntity))),
                new AuthorEntity(2L, "firstName2", "lastName2", LocalDate.now().minusYears(30), new ArrayList<>())
        ));
    }

    private void initOldAuthorEntities() {
        oldAuthorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(3L, "firstName3", "lastName3", LocalDate.now().minusYears(23), new ArrayList<>(Arrays.asList(bookEntity)))
        ));
    }

    private void initBookEntity() {
        bookEntity = new BookEntity(1L, "firstName", oldAuthorEntities, "description", now, new ArrayList<>());
    }

}