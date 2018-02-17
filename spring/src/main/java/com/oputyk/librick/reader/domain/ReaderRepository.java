package com.oputyk.librick.reader.domain;

import com.oputyk.librick.reader.domain.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamil on 17/02/2018.
 */

public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {

}
