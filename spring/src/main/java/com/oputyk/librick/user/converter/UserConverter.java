package com.oputyk.librick.user.converter;

import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.dto.CredentialsUserDto;
import com.oputyk.librick.user.dto.UserDto;

/**
 * Created by kamil on 17/02/2018.
 */
public interface UserConverter {
    UserDto toUserDto(UserEntity userEntity);

    UserEntity toUserEntity(UserDto userDto);

    UserEntity toUserEntity(CredentialsUserDto credentialsUserDto);
}
