package com.oputyk.librick.user.converter;

import com.oputyk.librick.common.converter.EntityDtoConverter;
import com.oputyk.librick.user.domain.UserEntity;
import com.oputyk.librick.user.domain.UserRepository;
import com.oputyk.librick.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kamil on 17/02/2018.
 */

@Service
public class UserConverterImpl implements UserConverter {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityDtoConverter converter;

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
            UserEntity oldUserEntity;
            oldUserEntity = findEntityAndCreateIfDoesntExist(userDto.getId());

            return (UserEntity) converter.toEntity(oldUserEntity, userDto);
    }

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        return (UserDto) converter.toDto(userEntity, UserDto.class);
    }

    private UserEntity findEntityAndCreateIfDoesntExist(Long id) {
            UserEntity userEntity = userRepository.findOne(id);

            if(userEntity == null) {
                userEntity = new UserEntity();
                userEntity.setId(id);

                userRepository.save(userEntity);
            }

            return userEntity;
    }
}
