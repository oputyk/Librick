package com.oputyk.librick.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamil on 03/02/2018.
 */

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
