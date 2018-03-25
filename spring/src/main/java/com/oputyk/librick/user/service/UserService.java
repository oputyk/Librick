package com.oputyk.librick.user.service;

import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.dto.ChangePasswordUserDto;
import com.oputyk.librick.user.dto.CredentialsUserDto;
import com.oputyk.librick.user.dto.UserDto;

/**
 * Created by kamil on 16/02/2018.
 */

public interface UserService {
    UserEntity findUserEntityByEmail(String email);

    UserDto findUserDtoById(Long id);

    UserDto findCurrentUserDto();

    UserDto findUserDtoByEmail(String name);

    boolean registerLibrarian(CredentialsUserDto credentialsUserDto);

    boolean changePassword(ChangePasswordUserDto changePasswordUserDto);
}
