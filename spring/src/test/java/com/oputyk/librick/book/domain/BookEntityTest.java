package com.oputyk.librick.book.domain;

import com.oputyk.librick.author.domain.AuthorEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    public void setUp() {
        initDate();
        initAuthorEntities();
        initOldAuthorEntities();
        initBookEntity();
        initRelationShips();
    }

    @Test
    public void testUpdateAuthorEntities() {
        bookEntity.updateAuthorEntities(authorEntities);
        assertThat(bookEntity.getAuthorEntities()).isEqualTo(authorEntities);
        assertThat(oldAuthorEntities.get(0).getBookEntities()).isEmpty();
    }

    @Test
    public void testAddAuthorEntity() {
        bookEntity.addAuthorEntity(authorEntities.get(0));
        bookEntity.addAuthorEntity(authorEntities.get(1));

        assertThat(bookEntity.getAuthorEntities().contains(authorEntities.get(0))).isTrue();
    }

    @Test
    public void testDeleteAuthorEntitiesByAddAuthorEntityFunction() {
        bookEntity.addAuthorEntity(authorEntities.get(0));
        bookEntity.addAuthorEntity(authorEntities.get(1));

        bookEntity.updateAuthorEntities(new ArrayList<>());

        assertThat(bookEntity.getAuthorEntities()).isEmpty();

        assertThat(authorEntities.get(0).getBookEntities()).isEmpty();
        assertThat(authorEntities.get(1).getBookEntities()).isEmpty();
    }

    private void initRelationShips() {
        bookEntity.setAuthorEntities(new ArrayList<>(Arrays.asList(oldAuthorEntities.get(0))));
        oldAuthorEntities.get(0).setBookEntities(new ArrayList<>(Arrays.asList(bookEntity)));
    }

    private void initDate() {
        now = LocalDate.now();
    }

    private void initAuthorEntities() {
        authorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(1L, "firstName", "lastName", LocalDate.now().minusYears(40), new ArrayList<>()),
                new AuthorEntity(2L, "firstName2", "lastName2", LocalDate.now().minusYears(30), new ArrayList<>())
        ));
    }

    private void initOldAuthorEntities() {
        oldAuthorEntities = new ArrayList<>(Arrays.asList(
                new AuthorEntity(3L, "firstName3", "lastName3", LocalDate.now().minusYears(23), new ArrayList<>())
        ));
    }

    private void initBookEntity() {
        bookEntity = new BookEntity(1L, "firstName", new ArrayList<>(), "description", now, new ArrayList<>());
    }

}