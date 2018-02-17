package com.oputyk.librick.user.service;

import com.oputyk.librick.user.domain.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by kamil on 16/02/2018.
 */

public interface UserService {
    UserEntity findUserEntityByEmail(String email);
}
