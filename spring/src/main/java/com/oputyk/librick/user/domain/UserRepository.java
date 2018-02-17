package com.oputyk.librick.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kamil on 11/02/2018.
 */


public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByEmail(String email);
}
