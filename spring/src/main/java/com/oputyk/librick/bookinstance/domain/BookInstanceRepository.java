package com.oputyk.librick.bookinstance.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamil on 03/02/2018.
 */

public interface BookInstanceRepository extends JpaRepository<BookInstanceEntity, Long> {
}
