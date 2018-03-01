package com.oputyk.librick.user.converter;

import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        return null;
    }
}
