package com.oputyk.librick.borrow.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamil on 05/02/2018.
 */

public interface BorrowRepository extends JpaRepository<BorrowEntity, Long> {

}
